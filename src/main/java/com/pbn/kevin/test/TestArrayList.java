package com.pbn.kevin.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-09-14 11:10:53
 **/
public class TestArrayList {

    private static int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public static void main(String[] args) {
        int max = Math.max(DEFAULT_CAPACITY, 1);
        System.out.println(max >> 1);
        System.out.println(MAX_ARRAY_SIZE);


        double a = 8.303070332638107e-05;
        DecimalFormat df = new DecimalFormat("0.000");
        String format = df.format(a);
        System.out.println(Double.parseDouble(format) < 0.05);
        boolean b = true;
        boolean c = true;
        boolean d = true;
        System.out.println(b && c && d);
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            test(aList, bList, i);
        }
        System.out.println(JSONObject.toJSONString(aList));
        System.out.println(JSONObject.toJSONString(bList));
        test1(aList, bList);
        System.out.println(JSONObject.toJSONString(aList));
        System.out.println(JSONObject.toJSONString(bList));
        List<PowerAttenuationMetricDTO> result = new ArrayList<>();
        for (int i=5;i>0;i--){
            PowerAttenuationMetricDTO metricDTO = new PowerAttenuationMetricDTO();
            metricDTO.setAlarmLevel(i);
            metricDTO.setLower4(4d);
            metricDTO.setLower8(8d);
            metricDTO.setLower16(16d);
            result.add(metricDTO);
        }
        System.out.println(JSONObject.toJSONString(result));
        //按告警级别升序
        result.sort(Comparator.comparingInt(PowerAttenuationMetricDTO::getAlarmLevel));
        System.out.println(JSONObject.toJSONString(result));

        Double aaaa = 56.8;
        Double bbb = aaaa/7;
        Double ccc = 94.5;
        Double ddd = ccc/bbb;
        System.out.println(ddd);
        System.out.println(ddd.intValue());
    }

    private static void test(List<String> aList, List<String> bList, int i) {
        aList.add("aaa" + i);
        bList.add("bbb" + i);
    }

    private static void test1(List<String> aList, List<String> bList) {
//        Iterator<String> paIt = bList.iterator();
//        while(paIt.hasNext()){
//            String powerAttenuation = paIt.next();
//            if (powerAttenuation.contains("2")){
//                paIt.remove();
//            }
//        }
        for (Iterator<String> it = aList.iterator(); it.hasNext(); ) {
            String powerAttenuation = it.next();
            if (powerAttenuation.contains("1")) {
                it.remove();
                bList.add(powerAttenuation);
            }
        }
    }
}
