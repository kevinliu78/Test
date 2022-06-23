package com.kevin.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LWS
 * @Date: 2020/9/14 15:10
 */
public class TestMapRemove {
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
        while (values.contains("111")){
            values.remove("111");
        }

        System.out.println("移除后：" + map);
    }
}
