package com.pbn.kevin.expiringmap;

import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

import java.util.concurrent.TimeUnit;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-07-21 17:12:38
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        test2();
    }


    private static void test1() throws Exception {
        /**
         *expiration(5000,TimeUnit.MILLISECONDS)
         *设置过期时间为5秒
         *ExpirationPolicy.CREATED)
         *设置过期策略为创建或更新值后
         */
        ExpiringMap<String, String> map = ExpiringMap.builder().expiration(5000, TimeUnit.MILLISECONDS)
                .expirationPolicy(ExpirationPolicy.CREATED)
                .build();
        map.put("key", "value");
        System.out.println("key:" + map.get("key"));
        //等待5秒
        Thread.sleep(5001);
        System.out.println(map.get("key"));
    }


    private static void test2() throws Exception {
        /**
         * ExpirationPolicy.CREATED：在每次更新元素时，过期时间同时清零。
         * ExpirationPolicy.ACCESSED：在每次访问元素时，过期时间同时清零。
         */
        ExpiringMap<String, String> map = ExpiringMap.builder().expiration(5000, TimeUnit.MILLISECONDS)
                .expirationPolicy(ExpirationPolicy.CREATED)
                .build();
        map.put("key", "value");
        System.out.println("key=" + map.get("key"));
        Thread.sleep(4000);
        System.out.println("访问map：key=" + map.get("key"));
        map.put("key1", "value1");
        Thread.sleep(1001);
        System.out.println("key=" + map.get("key"));
        System.out.println("key1=" + map.get("key1"));
        Thread.sleep(4005);
        System.out.println("访问map：key1=" + map.get("key1"));
        Thread.sleep(1001);
        System.out.println("访问map：key1=" + map.get("key1"));
    }

    private static void test3() throws Exception {
        ExpiringMap<String, String> map = ExpiringMap.builder().expiration(5000, TimeUnit.MILLISECONDS)
                .expirationPolicy(ExpirationPolicy.CREATED)
                .build();
        map.put("key", "value");
        System.out.println(map.get("key"));
        Thread.sleep(4000);
        map.put("key", "value2");
        System.out.println("更新map：" + map.get("key"));
        Thread.sleep(1001);
        System.out.println(map.get("key"));
    }


    private static void test4() throws Exception {
        ExpiringMap<String, String> map = ExpiringMap.builder().expiration(5000, TimeUnit.MILLISECONDS)
                .expirationPolicy(ExpirationPolicy.ACCESSED)
                .build();
        map.put("key", "value");
        System.out.println(map.get("key"));
        Thread.sleep(4000);
        System.out.println("访问map：" + map.get("key"));
        Thread.sleep(1001);
        System.out.println(map.get("key"));

    }

}
