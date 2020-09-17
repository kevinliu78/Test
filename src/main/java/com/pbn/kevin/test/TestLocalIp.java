package com.pbn.kevin.test;

import java.net.InetAddress;

/**
 * @Author: LWS
 * @Date: 2020/9/16 16:33
 */
public class TestLocalIp {
    public static void main(String[] args) throws Exception {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(new String(InetAddress.getLocalHost().getAddress(),"UTF-8"));
    }
}
