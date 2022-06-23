package com.pbn.kevin.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Author: LWS
 * @Date: 2020/9/15 16:28
 */
public class TestStringRegex2 {
    public static void main(String args[]) {
        String content = "component:drive,    status:FAILED, location:drive S/N:ZC118AJA0000C728LPYX in bay 30 in Drawer 1 of driveEnclosure S/N:7CE714P0PC, Message: The drive has failed.";
        String keyword = "component:drive,status:%wildcard%";
        content = stringFilter(content);
        System.out.println(content);
        keyword = stringFilter(keyword);
        keyword = keyword.replaceAll("%wildcard%", ".*");
//        keyword = keyword.replaceAll(" ","");
        keyword = ".*" + keyword + ".*";
        System.out.println(keyword);
        String negateKeyword = "^((?!" + keyword + ").)*";
        boolean isMatch = Pattern.matches(keyword, content);
        boolean isMatch1 = Pattern.matches(negateKeyword, content);
        System.out.println("字符串中是否包含了 'lws' 子字符串? " + isMatch);
        System.out.println("字符串中不包含'lws'? " + isMatch1);

    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$^&*()+=|{}':;',\\[\\]<>/?~！@#￥……&*（）——+|{}【】‘；：”“’。 ，、？\\u000A\\u0009\\\\]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll("").trim();
        return result;
//        return result.replaceAll(" ","");
    }
}