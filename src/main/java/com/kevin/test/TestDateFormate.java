package com.kevin.test;

import com.alibaba.fastjson.JSONObject;
import com.kevin.util.ConfigUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/6/19 14:32
 */
public class TestDateFormate {
    public static void main(String[] args) throws Exception {
        String str = "a,b,c,c";
        str = str.substring(0,str.length() - 1);
        System.out.println(str);

        Date date = ConfigUtil.parseDateTime24("2020-06-23 17:00:00");

        System.out.println(date);
        System.out.println(date.getTime() * 1000000);

        List<Double> list = new ArrayList<>();
        list.add(3.0d);
        list.add(3.3d);
        list.add(5.0d);
        list.add(3.8d);
        System.out.println(JSONObject.toJSONString(list));
        listSort(list);
        System.out.println(JSONObject.toJSONString(list));
    }

    private static void listSort(List<Double> list) {
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
    }


}
