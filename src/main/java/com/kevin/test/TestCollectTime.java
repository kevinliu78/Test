package com.kevin.test;

import com.kevin.util.ConfigUtil;

import java.util.Date;

/**
 * @Author: LWS
 * @Date: 2020/3/4 18:22
 */
public class TestCollectTime {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        long archieveTime = (t1/(5*60*1000)) * (5*60*1000);

        System.out.println(ConfigUtil.formatDate24(new Date(t1)));
        System.out.println(ConfigUtil.formatDate24(new Date(archieveTime)));

    }
}
