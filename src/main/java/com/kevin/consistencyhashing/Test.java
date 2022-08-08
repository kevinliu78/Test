package com.kevin.consistencyhashing;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-07 16:34:10
 **/
public class Test {

    private static int VIRTUAL_NODE_NUM = 5;

    public static void main(String[] args) {
        List<String> addressList = new ArrayList<>();
        addressList.add("102.168.135.215");
        addressList.add("102.168.135.15");
//        addressList.add("102.168.135.3");
//        addressList.add("102.168.135.4");
//        addressList.add("102.168.135.5");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 10000; i++) {
            String addr = hashJob(i, addressList);
            if (map.containsKey(addr)) {
                Integer count = map.get(addr);
                if (count == null) {
                    count = 0;
                }
                map.put(addr, count + 1);
            } else {
                map.put(addr, 1);
            }
//            System.out.println("jobId="+i+",分配地址："+addr);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key==" + entry.getKey() + ",value==" + entry.getValue());
        }
    }

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

        return hashCode & 0xffffffffL;
    }

    public static String hashJob(int jobId, List<String> addressList) {

        // ------A1------A2-------A3------
        // -----------J1------------------
        TreeMap<Long, String> addressRing = new TreeMap<Long, String>();
        for (String address : addressList) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                long addressHash = hash("SHARD-" + address + "-NODE-" + i);
                addressRing.put(addressHash, address);
            }
        }

        long jobHash = hash(String.valueOf(jobId));
        //获取一个子集。其所有对象的 key 的值大于等于 jobHash
        SortedMap<Long, String> lastRing = addressRing.tailMap(jobHash);
        if (!lastRing.isEmpty()) {
            return lastRing.get(lastRing.firstKey());
        }
        return addressRing.firstEntry().getValue();
    }
}
