package com.kevin.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LWS
 * @Date: 2019/8/29 14:49
 */
public class TestMapContainsKey {

    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("apple", 5);
        map.put("banana", 25);
        System.out.println("===================" + (map.containsKey("apple")));
        Map<String, String> map1 = new HashMap<>();
        map1.put("code11", "1");
        map1.put("code12", "2");
        map1.put("code13", "3");
        map1.put("code21", "4");
        map1.put("code22", "5");

        Map<String, List<String>> resultMap = new HashMap<>();
        for (Map.Entry<String, String> map : map1.entrySet()) {
            String key = map.getKey();
            key = key.substring(0, key.length() - 1);
            String value = map.getValue();
            if (resultMap.containsKey(key)) {
                List<String> list = resultMap.get(key);
                list.add(value);
                resultMap.put(key, list);
            } else {
                List<String> ruleIdList = new ArrayList<>();
                ruleIdList.add(value);
                resultMap.put(key, ruleIdList);
            }
        }
        System.out.println(resultMap.toString());
    }
}
