package com.kevin.test;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/8/14 11:04
 */
public class TestPageList {

    private static final Logger logger = LoggerFactory.getLogger(TestPageList.class);

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            list.add(i);
        }
        logger.info("分页前的数据大小：" + list.size());
        logger.info("分页前的数据：\n" + JSONObject.toJSONString(list));
        List<Integer> newList = pageList(3, 10, list);
        logger.info("分页后的数据大小：" + newList.size());
        logger.info("分页后的数据：\n" + JSONObject.toJSONString(newList));
    }

    private static List<Integer> pageList(int pageNum, int pageSize, List<Integer> list) {
        if (list != null && list.size() > 0) {
            int totalCount = list.size();
            int pageCount = 0;
            int m = totalCount % pageSize;
            if (m > 0) {
                pageCount = totalCount / pageSize + 1;
            } else {
                pageCount = totalCount / pageSize;
            }
            List<Integer> subList = new ArrayList<Integer>();
            if (m == 0) {
                subList = list.subList((pageNum-1) * pageSize, pageSize * pageNum);
            } else {
                if (pageNum == pageCount) {
                    subList = list.subList((pageNum-1) * pageSize, totalCount);
                } else {
                    subList = list.subList((pageNum-1) * pageSize, pageSize * pageNum);
                }
            }
            return subList;
        } else {
            return null;
        }
    }
}


