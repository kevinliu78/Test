package com.kevin.interview;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-01-11 15:51:21
 **/
public class TestFloat {

    public static void main(String[] args) {
        float a = 3*0.1f;
        float b = 0.3f;
        System.out.println(a==b);
        System.out.println(3*0.1==0.3);

        byte a1 = 127;
        byte b1 = 127;
        //b1 = a1 + b1; // 报编译错误:cannot convert from int to byte
        b1 += a1;
    }
}
