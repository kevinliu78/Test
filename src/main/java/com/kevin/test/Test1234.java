package com.kevin.test;

import java.util.Scanner;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2024-05-22 15:14:31
 **/
public class Test1234 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a == 0) {
                continue;
            }
            int sodas = 0;
            while (a >= 2) {
                sodas++;
                if (a == 2) {
                    a = a - 2;
                } else {
                    a = a - 3 + 1; // 换一瓶汽水，并加上归还的空瓶
                }
            }
            System.out.println(sodas);
        }
    }

}
