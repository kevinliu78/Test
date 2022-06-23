package com.pbn.kevin.test;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-04-24 15:47:35
 **/
public class TestSubString {

    public static void main(String[] args) {
        String str = "2022-04-15 16:26:13 ************* Receive trap from 192.168.9.10rr";
        int pos = str.lastIndexOf(" ");
        int pos1 = str.lastIndexOf(".");
        String ip = str.substring(pos,pos1+2).trim();
        System.out.println(ip);
    }
}
