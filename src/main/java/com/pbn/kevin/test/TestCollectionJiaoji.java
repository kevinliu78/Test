package com.pbn.kevin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 创建时间: 2018年7月2日上午9:07:25
 * @ClassName 类名称
 * @Description 类描述 集合取交集
 */
public class TestCollectionJiaoji {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        List<String> strList2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            strList.add("aaa>>" + i);
            strList2.add("aaa>>" + (10 - i));
        }

        strList.add("aaa>>11");
        strList2.add("aaa>>11");
        strList.add("aaa>>10");
        //求出交集
        strList2.retainAll(strList);
        System.out.println("交集大小：" + strList2.size());

        for (int i = 0; i < strList2.size(); i++) {
            System.out.println(strList2.get(i));
        }
    }
}
