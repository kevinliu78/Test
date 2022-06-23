package com.kevin.test;


/**
 * @author kevin
 * @version 创建时间: 2018年9月13日上午10:57:26
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringFomat {
	public static void main(String[] args) {
		int emsCode = 14;
		String cityCode = "GDS_GZS_01";
		String topic1 = String.format("TOPIC_CMTS_CHASSIS_%s_%s", emsCode, cityCode);
		System.out.println(topic1);
	}
}
