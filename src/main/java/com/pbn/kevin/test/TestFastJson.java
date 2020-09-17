package com.pbn.kevin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: LWS
 * @Date: 2020/5/9 17:10
 */
public class TestFastJson {
    public static void main(String[] args) {
        String result = "";
        String s = "{\"用途\":[\"开发测试\"],\"服务\":[\"块服务\"],\"区域\":[\"普通生产\"]}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            List<String> list = JSONArray.parseArray(value, String.class);
            for (String ss : list) {
                result += (key + ":" + ss + ",");
            }
        }
        System.out.println(result);
        result = result.substring(0, result.length() - 1);
        System.out.println(result);

        long a = 121155477504L;
        long b = 121096724480L;
        System.out.println((a-b)/300);
//        test();
    }

    public static void test() {
        Map<String, List<String>> stringListMap = new HashMap<>();
        String userGroupTag = "{\"用途\":[\"开发测试\"],\"服务\":[\"块服务\",\"FS服务\"]}";
        String tags = "用途:开发测试,服务:块服务,服务:FS服务";
//        stringListMap = userGroupTags(userGroupTag);
        stringListMap = buildTags(tags);
        stringListMap.forEach(
                (k, v) -> {
                    v.forEach(
                            value -> {
                                System.out.println("k======" + k + ",v====" + JSONObject.toJSONString(v) + ",value==" + value);
                                /**
                                 * {"用途":["开发测试"],"服务":["块服务","FS服务"]}
                                 * tags : 用途:开发测试,服务:块服务,服务:FS服务
                                 * k======用途,v====["开发测试"],value==开发测试
                                 * k======服务,v====["块服务","FS服务"],value==块服务
                                 * k======服务,v====["块服务","FS服务"],value==FS服务
                                 */
                            }
                    );
                }
        );
    }

    public static Map<String, List<String>> buildTags(String tags) {
        if (tags == null || "".equals(tags)) {
            return new HashMap<>();
        }
//String tags = "用途:开发测试,服务:块服务,服务:FS服务";

        String[] split = tags.split(",");
        Map<String, List<String>> resultMap = new HashMap<>();

        for (String tag : split) {
            String[] tagArr = tag.split(":");
            String key = tagArr[0];
            List<String> strList;
            if (resultMap.containsKey(key)){
                strList = resultMap.get(key);
            }else{
                strList = new ArrayList<>();
            }

            if (!strList.contains(tagArr[1])) {
                strList.add(tagArr[1]);
            }
            resultMap.put(key, strList);
        }
        return resultMap;
    }


    public static Map<String, List<String>> userGroupTags(String tags) {
        if (tags == null || "".equals(tags)) {
            return new HashMap<>();
        }

        JSONObject jsonObject = JSONObject.parseObject(tags);

        Map<String, Object> innerMap = jsonObject.getInnerMap();

        Set<Map.Entry<String, Object>> entries = innerMap.entrySet();
        Map<String, List<String>> resultMap = new HashMap<>();

        for (Map.Entry<String, Object> entry : entries) {
            List<String> strList = new ArrayList<>();
            String key = entry.getKey();
            String value = JSONArray.toJSONString(entry.getValue());

            List<String> valueStrings = JSON.parseArray(value, String.class);
            for (String string : valueStrings) {
                if (!strList.contains(string)) {
                    strList.add(string);
                }
            }
            resultMap.put(key, strList);
        }
        return resultMap;
    }
}
