package com.kevin.test;

import com.alibaba.fastjson2.JSONObject;
import com.kevin.util.NumberUtil;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author kevin
 * @version 创建时间: Mar 5, 20195:41:01 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestDouble {
    public static void main(String[] args) {
//		double startFreq = 997.6;
//		double space = 0.025;
//		for (int i = 0; i < 10; i++) {
//			System.out.println(startFreq+i*space);
//		}
//		double d1 = 997.65;
//		System.out.println(3*space);

        double mv = 00.2456;
        double mv1 = 1000;
        DecimalFormat df = new DecimalFormat("00.##");
        System.out.println(df.format(mv));
        System.out.println(df.format(mv1));
        double v = NumberUtil.parseNumber(mv, 2);
        double v1 = NumberUtil.parseNumber(mv1, 2);
        System.out.println(v);
        System.out.println(v1);

        String value = "-2";
        System.out.println(value.startsWith("-"));

        Map map = new HashMap();
        map.put("age", 111);
        map.put("name", "111");
        System.out.println(map.get("age"));
        System.out.println(map.get("age1") == null);
        JSONObject json = new JSONObject();
        System.out.println(json.getString("aaaa") == null);


        double totalBandwidthRate = 80;
        int compareTo = new Double(80).compareTo(totalBandwidthRate);
        System.out.println(compareTo);

        DecimalFormat df1 = new DecimalFormat("0.#########");
        double aa = 2.675858E-7;
        System.out.println("aa==" + df1.format(aa));

        double tau = -1.0;
        double slope = -0.123;

        boolean tauResult = tau < -0.2;
        boolean slopeResult = slope < -0.1;

        System.out.println(tauResult);
        System.out.println(slopeResult);

        double slope1 = -0.009255172413793113;
        double slope2 = -0.010388157894736873;
        double slope3 = -0.011539473684210596;
        boolean slopeResult1 = Math.abs(slope2) >= 0;
        boolean slopeResult2 = Math.abs(slope2) <= 0.02;
        System.out.println(Math.abs(slope2));
        System.out.println(slopeResult1);
        System.out.println(slopeResult2);

        System.out.println(nextDouble(70, 80));
        List<Double> list = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            list.add(nextDouble(70, 80));
        }
        System.out.println(list);

        long l1 = 3502;
        long l2 = 1500;
        System.out.println(l1 / l2);

        Double average = 842537625.24d;
        DecimalFormat df2 = new DecimalFormat("0.##");
        System.out.println("均值:" + df2.format(average));
    }


    public static double nextDouble(final double min, final double max) {
        double a = min + ((max - min) * new Random().nextDouble());
        DecimalFormat df1 = new DecimalFormat("0.##");
        return Double.parseDouble(df1.format(a));
    }
}
