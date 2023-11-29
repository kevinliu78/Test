package com.kevin.test;

import com.kevin.util.BrocadeParseUtils;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2023-02-22 17:41:28
 **/
public class TestPortName {

    /**
     * 设备名称的解析方式，支持以下几种：
     * fc#/# : fc1/3（默认）
     * slot#/port#: slot1port3
     * s#p# : s1p3
     */

    public static void main(String[] args) {
        String portNameFormat = "fc#/#";
        String portNameFormat1 = "s#p#";
        String portName = BrocadeParseUtils.getPortName(portNameFormat1, "1", "1");
        System.out.println(portName);

        String portName1 = "3/34";
        int i = portName1.indexOf("/");
        String substring = portName1.substring(0, i);
        String substring1 = portName1.substring(i+1);
        System.out.println(substring);
        System.out.println(substring1);

        String portIndex = "3/34";
        if (portIndex.contains("/")) {
            int a = portIndex.indexOf("/");
            //截取板卡号和端口号
            String slot = portIndex.substring(0, a);
            String port = portIndex.substring(a + 1);
            System.out.println(BrocadeParseUtils.getPortName(portNameFormat1, slot, port));
        }
    }
}
