package com.kevin;

import org.junit.Test;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-08 15:20:23
 **/
public class TestFinally {

    @Test
    public void test() {
        int i = 1;
        try {
            if (i == 1) {
                System.out.println("1111111111111111111111111111");
                return;
            }
            System.out.println("222222222222222222222222222222");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("33333333333333333333333333333333");
        }
    }
}
