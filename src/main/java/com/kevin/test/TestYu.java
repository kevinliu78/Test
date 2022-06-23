package com.kevin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2019/12/26 15:03
 */
public class TestYu {
    public static void main(String[] args) {
        boolean result = false;
        boolean b = true;
        List<Boolean> list = new ArrayList<>();
        list.add(false);
        list.add(false);
        list.add(true);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result = list.get(i);
            } else {
                result = result || list.get(i);
            }
            System.out.println(result);
            if (result) {
                break;
            }
        }
        System.out.println("result=============="+(result&&b));
    }
}
