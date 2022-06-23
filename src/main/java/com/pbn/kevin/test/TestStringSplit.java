package com.pbn.kevin.test;

/**
 * @Author: LWS
 * @Date: 2019/8/30 11:21
 */
public class TestStringSplit {
    public static void main(String[] args) {
        String s = "aa,bb,ccc,dd";
        for (String ss : s.split(",")) {
            System.out.println(ss);
        }

        String conditionDesc = "5分钟内存储风扇状态由正常转换为不正常，并连续1次不正常,产生告警;5分钟内存储风扇状态由不正常转换为正常，并连续1次正常,恢复告警;";

        String[] split = conditionDesc.split(";");
        for (String desc : split) {
            System.out.println(desc);
        }


        String resourceIdStr = "12";
        System.out.println(resourceIdStr.split(",")[0]);
    }
}
