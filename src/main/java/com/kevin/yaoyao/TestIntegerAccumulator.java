package com.kevin.yaoyao;

import java.util.Scanner;

/**
 * @desc 接收用户输入的一个整数n，计算S=1+(1+2)+(1+2+3)+...+(1+2+3+...+n),最终输出S。
 * @Author: LWS
 * @Date: 2021/6/2 10:27
 */
public class TestIntegerAccumulator {

    /**
     * 分析题目
     * 1、提炼公式：1+2+3+...+n = n(n+1)/2
     * 2、S=1+(1+2)+(1+2+3)+...+(1+2+3+...+n)实际是自然数1~n依次计算n(n+1)/2结果累加
     */

    public static void main(String[] args) {
        //java控制台输入数据获取对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[34;4m" + "请输入一个整数：" + "\033[0m");
        //控制台有数据输入才执行
        while (scanner.hasNextInt()) {
            //获取控制台最近一次输入的数据
            int n = scanner.nextInt();
            //计算表达式输出对象
            String expression = "";
            //累加和对象
            int s = 0;
            //循环计算n次n(n+1)/2
            for (int i = 1; i < n + 1; i++) {
                //生成表达式，便于理解，此处与计算处理逻辑无关
                expression += buildExpression(i) + "+";
                /**
                 * 计算核心逻辑
                 * 例如n=3，则i=1,2,3
                 * i=1，expression = 1; b=1*(1+1)/2=1; s=0+1
                 * i=2，expression = 1+(1+2); b=2*(2+1)/2=3; s=0+1+3
                 * i=3，expression = 1+(1+2)+(1+2+3); b=3*(3+1)/2=6; s=0+1+3+6=10;
                 */
                int b = i * (i + 1) / 2;
                s = s + b;
            }
            System.out.println("输出计算表达式：\nS = " + expression.substring(0, expression.length() - 1));
            System.out.println("输出计算结果：\nS = " + s);
            System.out.println("\033[34;4m" + "请输入一个整数：" + "\033[0m");
        }
    }

    /**
     * 生成表达式
     *
     * @param i
     * @return
     */
    private static String buildExpression(int i) {
        String str = "";
        if (i == 1) {
            str = "1";
        } else {
            str = "(";
            for (int j = 1; j < i + 1; j++) {
                str += j + "+";
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
        }
        return str;
    }
}
