package com.kevin.consistencyhashing;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-07 16:34:10
 **/
public class Test1 {

    private static int VIRTUAL_NODE_NUM = 5;

    public static void main(String[] args) {
        List<String> addressList = new ArrayList<>();
        addressList.add("102.168.135.1");
        addressList.add("102.168.135.2");
        addressList.add("102.168.135.3");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
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
            System.out.println("jobId="+i+",分配地址："+addr);
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

    //使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static String hashJob(int jobId, List<String> addressList) {

        // ------A1------A2-------A3------
        // -----------J1------------------
        TreeMap<Integer, String> addressRing = new TreeMap<>();
        for (String address : addressList) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                int addressHash = getHash("SHARD-" + address + "-NODE-" + i);
                addressRing.put(addressHash, address);
            }
        }

        int jobHash = getHash(String.valueOf(jobId));
        //获取一个子集。其所有对象的 key 的值大于等于 jobHash
        SortedMap<Integer, String> lastRing = addressRing.tailMap(jobHash);
        if (!lastRing.isEmpty()) {
            return lastRing.get(lastRing.firstKey());
        }
        return addressRing.firstEntry().getValue();
    }
}
