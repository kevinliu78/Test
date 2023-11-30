package com.kevin.time;

import com.kevin.util.ConfigUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-05-17 14:43:25
 **/
public class TestStringTime {
    private final static String PRE_TAG = "<span style='color:#F56C6C '>";
    private final static String POST_TAG = "</span>";
    public static void main(String[] args) throws ParseException {

//        String startTime = "<span style='color:#F56C6C '>300</span>秒内;开始时间:2022-05-17 14:39:00,结束时间:2022-05-17 14:40:00";
        String startTime = "qqqqceshi;测试;wandan;5分钟内;存储 写响应时间大于1累计1次，产生警告级别告警;当前值:[1.4,1.08],开始时间:2023-11-29 18:00:00,结束时间:2023-11-29 18:00:00";
//        String startTime = "5分钟内;存储 写响应时间大于1累计1次，产生警告级别告警;当前值:[1.4,1.08],开始时间:2023-11-29 18:00:00,结束时间:2023-11-29 18:00:00";
        //1秒内;存储 写响应时间大于1累计1次，产生警告级别告警;当前值:[1.36,1.04],开始时间:2023-11-29 17:30:00,结束时间:2023-11-29 17:30:00
        startTime=startTime.replaceAll("<span style='color:#F56C6C '>","");
        startTime=startTime.replaceAll("</span>","");
        int a1 = startTime.indexOf("开始时间:");
        int a2 = startTime.indexOf(",结束时间:");
        long interval = 0;
        if (startTime.contains("分钟内;")) {
            int a3 = startTime.indexOf("分钟内;");
            int a4 = startTime.lastIndexOf(";", a3);
            String s3 = startTime.substring(a4+1, a3);
            interval = Integer.parseInt(s3) * 60 * 1000L;
        } else if (startTime.contains("秒内;")) {
            int a3 = startTime.indexOf("秒内;");
            int a4 = startTime.lastIndexOf(";", a3);
            String s3 = startTime.substring(a4+1, a3);
            interval = Integer.parseInt(s3) * 1000L;
        }
        String s1 = startTime.substring(a1 + 5, a2);
        String s2 = startTime.substring(a2 + 6);
        System.out.println(s1);
        System.out.println(s2);
        Date date1 = ConfigUtil.parseDateTime24(s1);
        Date date2 = ConfigUtil.parseDateTime24(s2);
        long dateTime1 = date1.getTime() - 60000;
        long dateTime2 = date2.getTime() + 60000;
        long l1 = dateTime2-dateTime1;
        if (l1<interval){
            long l2 = interval-l1;
            dateTime1=dateTime1-l2;
        }
        String st1 = ConfigUtil.formatDate24(new Date(dateTime1));
        String st2 = ConfigUtil.formatDate24(new Date(dateTime2));
        System.out.println(st1);
        System.out.println(st2);

    }
}
