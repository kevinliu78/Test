package com.kevin.test;

import com.kevin.util.ConfigUtil;

/**
 * @author kevin
 * @version 创建时间: Nov 20, 20189:34:08 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestRoundNumber {
    public static void main(String[] args) {
        float a = 43.809643f;
        float b = -43.809643f;


        System.out.println(ConfigUtil.roundNumber(a));
        System.out.println(ConfigUtil.roundNumber(b));

        for (int i = 0; i < 10; i++) {

            System.out.print(((int) (Math.random() * 99) + 1) + "\t");

        }

    }
}
