package com.kevin.test;

import java.util.regex.Pattern;

/**
 * @Author: LWS
 * @Date: 2020/9/15 16:28
 */
public class TestStringRegex {
    public static void main(String args[]) {
//        String content = "I am noob from runoob.com.";
        String content = "I am noob from runoob.com.";

        String pattern = ".*runoob.*";

        String pattern1 = "\\b开头字符.*?结尾字符\\b";
        String pattern2 = "^I am.*com.$";

        boolean isMatch = Pattern.matches(pattern, content);
        boolean isMatch1 = Pattern.matches(pattern2, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        System.out.println("字符串中是以I am开头，以com.结束? " + isMatch1);

        String s1 = "*start*end*";
        String s2 = "*start*end";
        String s3 = "start*end*";
        String s4 = "start*end";
        System.out.println(count(s1));
        System.out.println(count(s2));
        System.out.println(count(s3));
        System.out.println(count(s4));
    }


    private static int count(String s) {
        int count = 0;
        while (s.indexOf("*") != -1) {
            count++;
        }
    return count;
    }
}
