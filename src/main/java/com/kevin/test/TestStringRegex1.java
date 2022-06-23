package com.kevin.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Author: LWS
 * @Date: 2020/9/15 16:28
 */
public class TestStringRegex1 {
    public static void main(String args[]) {
//        String content = "I am lw1s from julu.";
//        String content = "Enterprilw.se: 1.3.6.1.4.1.48871.1.1.2.0.1\n  <&&>1.3.6.1.4.1.48871.1.1.2.1.1 := event\n  1.3.6.1.4.1.48871.1.1.2.1.2 := warning\n  1.3.6.1.4.1.48871.1.1.2.1.3 := pool\n  1.3.6.1.4.1.48871.1.1.2.1.4 := 3\n  1.3.6.1.4.1.48871.1.1.2.1.5 := DataPool\n  1.3.6.1.4.1.48871.1.1.2.1.6 := \n  1.3.6.1.4.1.48871.1.1.2.1.7 := degraded\n  1.3.6.1.4.1.48871.1.1.2.1.8 := degraded\n  1.3.6.1.4.1.48871.1.1.2.1.9 := \n\n";
//        String content = "Enterpril\\w\nse: 1.3.\t6.1.4.1.[48871].1.1.2.0.1\n  <&&>";
//        String content = "File sylwstem ifs1 sapce 95.0% full.Increase storage capacity or delete data from file system ifs1 to prevent backup failure. Root Cause: The specified filesystem is approching capacity. Recommended Action: Immediately increase storage capacity or delete data from file system to prevent imminent backup failure.";
        String content = "component:drive, status:FAILED, location:drive S/N:ZC118AJA0000C728LPYX in bay 30 in Drawer 1 of driveEnclosure S/N:7CE714P0PC, Message: The drive has failed.";
        String keyword = ".*lw.s.*";
        content = stringFilter(content);
        System.out.println(content);
        keyword = stringFilter(keyword);
        keyword = ".*" + keyword + ".*";
        String negateKeyword = "^((?!" + keyword + ").)*";
        boolean isMatch = Pattern.matches(keyword, content);
        boolean isMatch1 = Pattern.matches(negateKeyword, content);
        System.out.println("字符串中是否包含了 'lws' 子字符串? " + isMatch);
        System.out.println("字符串中不包含'lws'? " + isMatch1);

        String keyword1 = "l%wildcard%ws";
        //去除关键字中的特殊字符
        keyword1 = stringFilter(keyword1);
        keyword1 = keyword1.replaceAll("%wildcard%", ".*");
        keyword1 = ".*" + keyword1 + ".*";
        System.out.println(keyword1);
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$^&*()+=|{}':;',\\[\\]<>/?~！@#￥……&*（）——+|{}【】‘；：”“’。 ，、？\\u000A\\u0009\\\\]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll(" ").trim();
    }
}