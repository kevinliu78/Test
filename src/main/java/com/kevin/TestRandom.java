package com.kevin;

import java.util.Random;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-25 16:55:47
 **/
public class TestRandom {

    public static void main(String[] args) {
//        Random r = new Random();
//        for (int i = 0; i < 10; i++) {
//            //r.nextInt(n)  n为几  就产生0~n-1的随机数
//            int num = r.nextInt(2)+1;
//            System.out.print(num+"\t");
//        }

        String trapCode = 1234 + "";
        String severity = trapCode.substring(trapCode.length() - 1);
        System.out.println(severity);
    }
}
