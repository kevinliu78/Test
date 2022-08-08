package com.kevin.jsonobject;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-04-12 16:35:10
 **/
public class Test {

    public static void main(String[] args) {
        CompareImportRuleVO compareImportRuleVO = new CompareImportRuleVO();
        compareImportRuleVO.setImportRuleId(1);
        compareImportRuleVO.setCurrentRuleId(1);
        compareImportRuleVO.setCompareRuleOperationType(1);
        compareImportRuleVO.setFileName("sss");
        compareImportRuleVO.setMergeFileName("aaaa");
        List<CompareImportRuleVO> result = new ArrayList<>();
        result.add(compareImportRuleVO);
        String param = JSONObject.toJSONString(result);

        List<CompareImportRuleVO> compareImportRuleVOS = JSON.parseArray(param, CompareImportRuleVO.class);
        for (CompareImportRuleVO c : compareImportRuleVOS){
            System.out.println(JSONObject.toJSONString(c));
        }

        Integer currentRuleId = compareImportRuleVO.getCurrentRuleId();
        System.out.println(compareImportRuleVO.getCurrentRuleId());
        compareImportRuleVO.setCurrentRuleId(10);
        System.out.println(compareImportRuleVO.getCurrentRuleId());
    }
}
