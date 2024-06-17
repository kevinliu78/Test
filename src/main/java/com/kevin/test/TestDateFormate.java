package com.kevin.test;

import com.alibaba.fastjson2.JSONObject;
import com.kevin.util.ConfigUtil;
import com.kevin.util.DateFormatUtil;

import java.text.DecimalFormat;
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


        long t1 = System.currentTimeMillis();
        System.out.println(DateFormatUtil.formatDateTime24(new Date(t1)));

        String time = "2021-12-28 13:00:00";
        Date date1 = DateFormatUtil.parseDateTime24(time);
        System.out.println(DateFormatUtil.formatDateTime24(date1));
        System.out.println(time.substring(11, 19));
        System.out.println(time.substring(5, 16));
        System.out.println(DateFormatUtil.getLast24HoursTime());

        long dataTimeMillis = System.currentTimeMillis();
        int step = 900;
        if (step>=3600){
            //时间对齐处理
            System.out.println(DateFormatUtil.formatDateTime24(new Date(dataTimeMillis)));
            dataTimeMillis = (dataTimeMillis / (3600 * 1000)) * (3600 * 1000);
            System.out.println(DateFormatUtil.formatDateTime24(new Date(dataTimeMillis)));
        }else{
            //时间对齐处理
            System.out.println(DateFormatUtil.formatDateTime24(new Date(dataTimeMillis)));
            dataTimeMillis = (dataTimeMillis / (step * 1000)) * (step * 1000);
            System.out.println(DateFormatUtil.formatDateTime24(new Date(dataTimeMillis)));
        }
//        Date requestDate = DateFormatUtil.getZeroDateBeforeWeek();
//        String requestTime = DateFormatUtil.formatDateTime24(requestDate);
//        String afterDayTime = DateFormatUtil.getAfterDayTime(requestTime);
//        System.out.println(afterDayTime);
//
//        int clearPeriod = 2;
//        //保留固定间隔内的告警
//        Date zeroDateBeforePriod = DateFormatUtil.getZeroDateBeforePriod(clearPeriod - 1);
//        //需要清除这个时间以前的告警
//        System.out.println(DateFormatUtil.formatDateTime24(zeroDateBeforePriod));
//
//        String day = "2024-04-02 17:10:00";
//        System.out.println(DateFormatUtil.formatDateTime24(DateFormatUtil.getZeroDateByDay(DateFormatUtil.parseDateTime24(day))));
//        System.out.println(DateFormatUtil.getZeroDateByDay(DateFormatUtil.parseDateTime24(day)).getTime());
//        System.out.println(DateFormatUtil.getNextDayZeroDateByDay(DateFormatUtil.parseDateTime24(day)).getTime());
//        DecimalFormat df = new DecimalFormat("0.00");

    }

    private static void listSort(List<Double> list) {
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
    }


}
