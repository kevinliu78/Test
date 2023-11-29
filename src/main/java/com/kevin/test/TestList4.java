package com.kevin.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: LWS
 * @Date: 2020/11/17 13:48
 */
public class TestList4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(5);
        list2.add(7);
        List<Integer> commonElements = findCommonElements(list, list2);
        System.out.println(commonElements.size());
        int a = 1;
        for (Integer i : commonElements) {
            System.out.println("system out ==" + a + "==>>>" + i);
            a++;
        }
    }

    /**
     * @param list1
     * @param list2
     * @return java.util.List<java.lang.Integer>
     * @Description 查找两个list重合元素
     * @Author Liuws
     * @Date 2023/11/8 17:49
     */
    private static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        List<Integer> result = new ArrayList<>();
        for (Integer item : list2) {
            if (set1.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
