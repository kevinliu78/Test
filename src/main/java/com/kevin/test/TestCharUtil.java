package com.kevin.test;

import com.kevin.util.CharUtil;

/**
 * @author kevin
 * @version 创建时间: 2018年9月3日下午1:26:55
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestCharUtil {
	public static void main(String[] args) {
		String address = "黑龙江哈尔滨市区南岗区蓝天荣府3栋2单元20楼1室";
		System.out.println(CharUtil.isChinese(address));
	}
}
