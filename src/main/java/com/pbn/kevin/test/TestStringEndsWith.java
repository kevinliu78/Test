package com.pbn.kevin.test;

/**
 * @Author: LWS
 * @Date: 2021/1/19 11:27
 */
public class TestStringEndsWith {

    public static void main(String[] args) {
        String fileName1= "filterRule.json";
        String fileName2= "filterRule.b64";

        System.out.println(fileName1.endsWith("b64"));
        System.out.println(fileName2.endsWith("b64"));
    }
}
