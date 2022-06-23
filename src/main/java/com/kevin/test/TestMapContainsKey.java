package com.kevin.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LWS
 * @Date: 2019/8/29 14:49
 */
public class TestMapContainsKey {

    private static final Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("apple",5);
        map.put("banana",25);
        System.out.println("==================="+(map.containsKey("apple")));
    }
}
