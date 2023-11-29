package com.kevin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Program: monitor-center
 * @Description:
 * @Author: Liuws
 * @Date: 2022-04-25 16:49:38
 **/
public class StringRegexpFilterUtil {

    /**
     * @Description 字符串清除特殊字符
     * @Author Liuws
     * @param str
     * @Date 2022/4/25 16:50
     * @return java.lang.String
     */
    public static String stringFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$^&*()+=|{}':;',\\[\\].<>/?~！@#￥……&*（）——+|{}【】‘；：”“’。 ，、？\\u000A\\u0009\\\\]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
