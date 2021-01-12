package com.pbn.kevin.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/11/17 13:48
 */
public class TestList {
    public static List<Integer> systemRuleId2FeatureList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Integer ruleId = 5;
        systemRuleId2FeatureList.add(1);
//        systemRuleId2FeatureList.add(5);
        systemRuleId2FeatureList.add(2);
        systemRuleId2FeatureList.add(3);
        systemRuleId2FeatureList.add(4);
        systemRuleId2FeatureList.add(7);
        systemRuleId2FeatureList.add(6);
        systemRuleId2FeatureList.add(3);
        System.out.println(systemRuleId2FeatureList.toString());
        systemRuleId2FeatureList.remove(ruleId);
        System.out.println(systemRuleId2FeatureList.toString());
    }
}
