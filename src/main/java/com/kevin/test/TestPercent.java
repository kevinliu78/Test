package com.kevin.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-07-28 17:47:20
 **/
public class TestPercent {

    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        System.out.println(getPercent(a,b));
        System.out.println(getPercent2(a,b));

        Double d = 88.6D;
        Double d1 = 88.5D;
        Double d2 = 88.7D;
        System.out.println(d.intValue());
        System.out.println(d.compareTo(d1));
        System.out.println(d.compareTo(d2));
        Double totalBandwidthRate1 = 75d;
        Double totalBandwidthRate2 = 85d;
        int compareTo1 = new Double(80).compareTo(totalBandwidthRate1);
        int compareTo2 = new Double(80).compareTo(totalBandwidthRate2);
        System.out.println(compareTo1);
        System.out.println(compareTo2<0);

        int total = 0;
        int abnormal = 0;
        List<Double> valueList = new ArrayList<>();
        valueList.add(81.6d);
        valueList.add(71.6d);
        valueList.add(61.6d);
        valueList.add(91.6d);
        valueList.add(81.6d);
        for (Double value : valueList) {
            Double totalBandwidthRate = value;
            int compareTo = new Double(80).compareTo(totalBandwidthRate);
            if (compareTo < 0) {
                abnormal++;
            }
            total++;
        }
        if (abnormal > total / 2) {
            System.out.println("指标值超过80%的超过一半了");
        }
    }

    /**
     * 方式一：使用java.text.NumberFormat实现
     * @param x
     * @param y
     * @return
     */
    public static String getPercent(int x, int y) {
        double d1 = x * 1.0;
        double d2 = y * 1.0;
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        // 设置保留几位小数，这里设置的是保留两位小数
        percentInstance.setMinimumFractionDigits(2);
        return percentInstance.format(d1 / d2);
    }

    /**
     * 方式二：使用java.text.DecimalFormat实现
     * @param x
     * @param y
     * @return
     */
    public static String getPercent2(int x, int y) {
        double d1 = x * 1.0;
        double d2 = y * 1.0;
        // 设置保留几位小数， “.”后面几个零就保留几位小数，这里设置保留四位小数
        DecimalFormat decimalFormat = new DecimalFormat("##.0000%");
        return decimalFormat.format(d1 / d2);
    }

}
