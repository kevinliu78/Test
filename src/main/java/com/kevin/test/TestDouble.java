package com.kevin.test;

import com.alibaba.fastjson.JSONObject;
import com.kevin.util.NumberUtil;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @version 创建时间: Mar 5, 20195:41:01 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestDouble {
	public static void main(String[] args) {
//		double startFreq = 997.6;
//		double space = 0.025;
//		for (int i = 0; i < 10; i++) {
//			System.out.println(startFreq+i*space);
//		}
//		double d1 = 997.65;
//		System.out.println(3*space);

		double mv = 00.2456;
		double mv1 = 1000;
		DecimalFormat df = new DecimalFormat("00.##");
		System.out.println(df.format(mv));
		System.out.println(df.format(mv1));
		double v = NumberUtil.parseNumber(mv, 2);
		double v1 = NumberUtil.parseNumber(mv1, 2);
		System.out.println(v);
		System.out.println(v1);

		String value = "-2";
        System.out.println(value.startsWith("-"));

        Map map = new HashMap();
        map.put("age",111);
        map.put("name","111");
        System.out.println(map.get("age"));
        System.out.println(map.get("age1") == null);
		JSONObject json = new JSONObject();
		System.out.println(json.getString("aaaa") == null);
	}
}
