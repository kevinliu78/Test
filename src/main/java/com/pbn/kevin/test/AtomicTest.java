package com.pbn.kevin.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LWS
 * @Date: 2019/10/30 17:01
 */
public class AtomicTest {

    private static AtomicInteger count = new AtomicInteger();

    public static Integer getQualityNum(int end) {
        count.set(end);
        count.incrementAndGet();
        int i = count.get();
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getQualityNum(90));

    }

}
