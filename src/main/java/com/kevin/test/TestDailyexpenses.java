package com.kevin.test;

import java.util.Scanner;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2023-03-20 14:21:17
 **/
public class TestDailyexpenses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个a1: ");
        int a1 = scanner.nextInt();
        System.out.println("请输入一个a2: ");
        int a2 = scanner.nextInt();
        System.out.println("请输入一个b1: ");
        int b1 = scanner.nextInt();
        System.out.println("请输入一个b2: ");
        int b2 = scanner.nextInt();
        System.out.println("请输入一个b3: ");
        int b3 = scanner.nextInt();
        System.out.println("3560请3854输入一个b4: ");
        int b4 = scanner.nextInt();
        int c = a1-a2-b1-b2-b3-b4;
        System.out.println("c===="+c);
        scanner.close();
    }
}
