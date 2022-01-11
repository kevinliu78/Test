package com.pbn.kevin;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-07-19 15:48:35
 **/
public class TestLocalAddress {
    public static void main(String[] args) {
        try {
            InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
