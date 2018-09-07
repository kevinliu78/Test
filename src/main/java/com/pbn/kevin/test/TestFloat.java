package com.pbn.kevin.test;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年8月23日下午2:13:40
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFloat {
	public static void main(String[] args) {
		ObjectNode json = Convert.newObject();
		json.put("cmUpSnr", "0");
		Float upSnr = json.get("cmUpSnr") != null ? Float.parseFloat(json.get("cmUpSnr").asText()) : 0;
		System.out.println(upSnr.equals(0f));
	}
}
