package com.kevin.test;

import com.alibaba.fastjson2.JSONObject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: LWS
 * @Date: 2020/9/14 15:10
 */
public class TestMapRemove {
    private static Map<Long, List<Integer>> resourceId2FeatureRuleIdMap = new HashMap<>();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "111");
        map.put("key2", "222");
        map.put("key3", "111");
        map.put("key4", "333");
        map.put("key5", "111");
        map.put("key6", "444");
        Collection<String> values = map.values();
        System.out.println("移除前：" + map);
        while (values.contains("111")) {
            values.remove("111");
        }
        System.out.println("移除后：" + map);
        resourceId2FeatureRuleIdMap.put(1001L, new ArrayList<>());
//        resourceId2FeatureRuleIdMap.put(1002L, new ArrayList<>());
//        resourceId2FeatureRuleIdMap.put(1003L, new ArrayList<>());
//        resourceId2FeatureRuleIdMap.put(1004L, new ArrayList<>());
        add(1001L,1);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));
        add(1001L,1);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));
        add(1001L,2);
        add(1001L,3);
        add(1001L,4);
        add(1001L,5);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));
        remove(1001L,1);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));
        remove(1001L,3);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));
        resourceId2FeatureRuleIdMap.remove(1002L);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));
        resourceId2FeatureRuleIdMap.remove(1001L);
        System.out.println(JSONObject.toJSONString(resourceId2FeatureRuleIdMap));

    }

    private static void add(Long resourceId, Integer ruleId) {
        if (!resourceId2FeatureRuleIdMap.get(resourceId).contains(ruleId)) {
            resourceId2FeatureRuleIdMap.get(resourceId).add(ruleId);
        }
    }

    private static void remove(Long resourceId, Integer ruleId) {
        resourceId2FeatureRuleIdMap.get(resourceId).remove(ruleId);
    }
}
