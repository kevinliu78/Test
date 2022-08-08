package com.kevin.test;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kevin
 * @version 创建时间: Feb 25, 20192:32:19 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFor {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("name1");
        list.add("name2");
        list.add("name3");
        list.add("name4");
        map.put(0, list);
        map.put(1, list);
        map.put(2, list);
        boolean flag = test1(map, "name3");
        System.out.println(flag);
        System.out.println(JSONObject.toJSONString(map));
    }

    private static boolean test1(Map<Integer, List<String>> map, String mqName) {
        for (int i = 0; i < 3; i++) {
            List<String> list = map.get(i);
            for (String name : list) {
                if (mqName.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
