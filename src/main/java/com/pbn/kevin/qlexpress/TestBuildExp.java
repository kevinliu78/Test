package com.pbn.kevin.qlexpress;

import org.apache.commons.lang.StringUtils;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-02-18 17:09:24
 **/
public class TestBuildExp {

    public static void main(String[] args) {
        String value = "123";
        String s = toStringExp(value);
        System.out.println(value);
        System.out.println(s);
        String fieldValue = "fieldValue ";
        String exp = fieldValue + "equal" + " (" + s + ")";
        System.out.println(exp);
        System.out.println(exp.indexOf("(\""));
        System.out.println(exp.indexOf("(\"") + 2);
        System.out.println(exp.indexOf("\")"));
        String val = exp.substring(exp.indexOf("(\"")+1, exp.indexOf("\")"));
        System.out.println(val);
    }

    private static String toStringExp(String value) {
        String result;
        if (value.startsWith("[")) {
            result = StringUtils.substringBetween(value, "[", "]");
        } else {
            result = value;
        }

        String[] str = StringUtils.split(result, ",");
        for (int i = 0; i < str.length; i++) {
            str[i] = "\"" + str[i] + "\"";

        }
        result = StringUtils.join(str, ",");
        if (value.startsWith("[")) {
            result = "[" + result + "]";
        }

        return result;
    }
}
