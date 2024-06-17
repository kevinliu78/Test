package com.kevin.list;

import java.util.*;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2024-02-28 16:03:38
 **/
public class TestListSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = list.stream().reduce(0, (a, b) -> a + b);

        int sum2 = list.stream().mapToInt(Integer::intValue).sum();

        int sum3 = list.parallelStream().reduce(0, (a, b) -> a + b);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);

        List<Double> doubleList = Arrays.asList(1d, 2d, 3d, 4d, 5.5d);
        int sum = doubleList.stream().mapToInt(Double::intValue).sum();
        OptionalDouble average = doubleList.stream().mapToDouble(Double::doubleValue).average();
        OptionalInt max1 = doubleList.stream().mapToInt(Double::intValue).max();
        Optional<Double> max = doubleList.stream().max(Comparator.comparing(Double::intValue));

        System.out.println(sum);
        System.out.println(average.getAsDouble());
        System.out.println(max.get());
        System.out.println(max1.getAsInt());
    }
}
