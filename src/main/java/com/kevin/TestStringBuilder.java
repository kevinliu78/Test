package com.kevin;

/**
 * @Author: LWS
 * @Date: 2020/11/26 9:42
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("a");
        System.out.println(s.toString());

        int size = 2;
        int count = (int) Math.floor(Math.log10(size) + Math.log(size) + 1);
        System.out.println(count);
    }
}
