package com.pbn.kevin.test;

/**
 * @Author: LWS
 * @Date: 2019/8/30 11:21
 */
public class TestStringSplit {
    public static void main(String[] args) {
        String s = "aa,bb,ccc,dd";
        for(String ss : s.split(",")){
            System.out.println(ss);
        }
    }
}
