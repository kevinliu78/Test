package com.kevin.test;

import com.alibaba.fastjson2.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author kevin
 * @version 创建时间: Nov 15, 20185:31:44 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestMap {

    private static Map<String, List<String>> deviceHashMap = new HashMap<>();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(map.get("1"));
        String ip = "33.1.132.47,33.1.132.49";
        String myip = "33.1.132.47";
        String deviceId = "1000889471DA9580";
        for (int i = 0; i < 10; i++) {
            if (i > 2) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        deviceHashMap = queryDeviceHashListByIp(ip);
                        System.out.println(deviceHashMap.hashCode());
                        System.out.println(JSONObject.toJSONString(deviceHashMap));
                        List<String> deviceIdList = queryDeviceIdList();
                        List<String> otherDeviceIdList = queryOtherDeviceIdList();
                        System.out.println(deviceIdList);
                        System.out.println(otherDeviceIdList);
                        if (deviceIdList != null && otherDeviceIdList != null && !deviceIdList.contains(deviceId) && otherDeviceIdList.contains(deviceId)) {
                            System.out.println("本机不处理");
                            return;
                        }
                        System.out.println("本机需要处理");
                    }
                }).start();
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //第一次取全部的
                        deviceHashMap = queryDeviceHashListByIp(myip);
                        System.out.println(deviceHashMap.hashCode());
                        System.out.println(JSONObject.toJSONString(deviceHashMap));
                        List<String> deviceIdList = queryDeviceIdList();
                        List<String> otherDeviceIdList = queryOtherDeviceIdList();
                        System.out.println(deviceIdList);
                        System.out.println(otherDeviceIdList);
                        if (deviceIdList != null && otherDeviceIdList != null && !deviceIdList.contains(deviceId) && otherDeviceIdList.contains(deviceId)) {
                            System.out.println("本机不处理");
                            return;
                        }
                        System.out.println("本机需要处理");
                    }
                }).start();
            }
            //10s后取平均的
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> queryDeviceIdList() {
        try {
            return deviceHashMap.get("33.1.132.47");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> queryOtherDeviceIdList() {
        try {
            return deviceHashMap.get("33.1.132.49");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int VIRTUAL_NODE_NUM = 5;

    /**
     * get hash code on 2^32 ring (md5散列的方式计算hash值)
     *
     * @param key
     * @return
     */
    private static long hash(String key) {

        // md5 byte
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
        md5.reset();
        byte[] keyBytes = null;
        try {
            keyBytes = key.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unknown string :" + key, e);
        }

        md5.update(keyBytes);
        byte[] digest = md5.digest();

        // hash code, Truncate to 32-bits
        long hashCode = ((long) (digest[3] & 0xFF) << 24) | ((long) (digest[2] & 0xFF) << 16) | ((long) (digest[1] & 0xFF) << 8) | (digest[0] & 0xFF);

        long truncateHashCode = hashCode & 0xffffffffL;
        return truncateHashCode;
    }

    /**
     * @param ip eg: 192.168.135.215,192.168.135.15
     * @return java.util.Map<java.lang.String, java.util.List < java.lang.String>>
     * @Description 平均分配存储设备信息
     * @Author Liuws
     * @Date 2022/6/28 17:09
     */
    public static Map<String, List<String>> queryDeviceHashListByIp(String ip) {
        if (ip == null || ip.isEmpty()) {
            return null;
        } else {
            String[] split = ip.split(",");
            List<String> ipList = new ArrayList<>(Arrays.asList(split));
            Map<String, List<String>> result = new HashMap<>();
            List<String> storageIdList = new ArrayList<>();
            storageIdList.add("1000889471ED2C70");
            storageIdList.add("1000889471EEC910");
            storageIdList.add("1000889471DA9580");
            storageIdList.add("1000889471933FA8");
            storageIdList.add("10000027F8F84600");
            storageIdList.add("1000889471BF652C");
            storageIdList.add("1000889471ED64F0");
            storageIdList.add("100088947193AD18");
            storageIdList.add("10008894719D4C53");
            storageIdList.add("10008894719C9ECC");
            if (storageIdList.size() > 0) {
                for (String deviceId : storageIdList) {
                    String ipAddress = hashDeviceId(deviceId, ipList);
                    if (result.containsKey(ipAddress)) {
                        result.get(ipAddress).add(deviceId);
                    } else {
                        //ip地址缓存初始化
                        List<String> deviceIdList = new ArrayList<>();
                        deviceIdList.add(deviceId);
                        result.put(ipAddress, deviceIdList);
                    }
                }
            }
//			List<String> switchWwnList = querySwitchList();
//			if (switchWwnList != null && switchWwnList.size() > 0) {
//				for (String deviceId : switchWwnList) {
//					String ipAddress = hashDeviceId(deviceId, ipList);
//					if (result.containsKey(ipAddress)) {
//						result.get(ipAddress).add(deviceId);
//					} else {
//						//ip地址缓存初始化
//						List<String> deviceIdList = new ArrayList<>();
//						deviceIdList.add(deviceId);
//						result.put(ipAddress, deviceIdList);
//					}
//				}
//			}
            return result;
        }
    }

    //设备ID计算hash
    public static String hashDeviceId(String deviceId, List<String> addressList) {
        // ------A1------A2-------A3------
        // -----------J1------------------
        TreeMap<Long, String> addressRing = new TreeMap<>();
        for (String address : addressList) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                long addressHash = hash("SHARD-" + address + "-NODE-" + i);
                addressRing.put(addressHash, address);
            }
        }

        long jobHash = hash(deviceId);
        //获取一个子集。其所有对象的 key 的值大于等于 jobHash
        SortedMap<Long, String> lastRing = addressRing.tailMap(jobHash);
        if (!lastRing.isEmpty()) {
            return lastRing.get(lastRing.firstKey());
        }
        return addressRing.firstEntry().getValue();
    }
}
