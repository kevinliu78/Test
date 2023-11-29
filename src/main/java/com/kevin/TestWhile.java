package com.kevin;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-04-22 18:00:10
 **/
public class TestWhile {

    public static void main(String[] args) {
        String ruleName = "测试";
        int count = 0;
        while (true) {
            String s = ruleName;
            for (int i = 0; i < count; i++) {
                s += "_name";
            }
            if (!isRuleNameExist(s)) {
                ruleName = s;
                //该名称未使用，修改名称
//                filterRule.setRuleName(ruleName);
                break;
            }
            count++;
        }
        System.out.println(count);
        System.out.println(ruleName);
    }

    private static boolean isRuleNameExist(String ruleName) {
        if ("测试".equals(ruleName)) {
            return true;
        }else if ("测试_name1".equals(ruleName)) {
            return true;
        } else if ("测试_name_name".equals(ruleName)) {
            return true;
        } else if ("测试_name_name_name".equals(ruleName)) {
            return true;
        } else {
            return false;
        }
    }
}
