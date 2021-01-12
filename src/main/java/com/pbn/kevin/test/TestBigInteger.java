package com.pbn.kevin.test;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * @Author: LWS
 * @Date: 2020/11/23 18:00
 */
public class TestBigInteger {
    public static void main(String[] args) {
        String currentValue = "0";
        String previousValue = "0";
        int step = 60;
        BigInteger bigCurrentValue = new BigInteger(currentValue);
        BigInteger bigPreviousValue = new BigInteger(previousValue);
        if (bigCurrentValue.compareTo(bigPreviousValue) >= 0) {
            long lDelta = bigCurrentValue.subtract(bigPreviousValue).longValue();
            double mv = (lDelta * 1.0) / step;
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(mv));

            double a = 0.0/0.0;
        }
    }
}
