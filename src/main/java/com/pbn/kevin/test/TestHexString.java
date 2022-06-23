package com.pbn.kevin.test;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-16 14:40:23
 **/
public class TestHexString {
    public static void main(String[] args) {
        String hexStr = "0x44:69:73:6B:2D:31:3A:31:3A:31:3A:39:B0:B2:C8:AB:CF:C2:B5:E7:A1:A3";
        System.out.println(hexStr.startsWith("0x"));

        String messageCode = "17432577";
        messageCode = "0X" + Long.toHexString(Long.parseLong(messageCode)).toUpperCase();
        System.out.println(messageCode);

        System.out.println(getEventLevel("warning"));
    }


    private static int getEventLevel(String alertLevel) {
        int eventLevel = 0;
        //翻译告警级别
        if ("info".equals(alertLevel)) {
            eventLevel = 1;
        } else if ("warning".equals(alertLevel)) {
            eventLevel = 2;
        } else if ("error".equals(alertLevel)) {
            eventLevel = 3;
        }
        return eventLevel;
    }
}
