package com.kevin.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/11/17 13:48
 */
public class TestList3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("list size == " + list.size());
        System.out.println("list get 5 ===" + list.get(5));
        System.out.println("list get 7 ===" + list.get(7));
    }
}
