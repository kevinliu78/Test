package com.kevin.test;

import java.io.File;
import java.io.FileInputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年3月28日下午3:56:36
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFile {
	public static void main(String[] args) throws Exception {
		String filePath = "doc/test1.json";
		File f = new File(filePath);
		if(f.exists()) {
			ObjectNode json = (ObjectNode) Convert.parse(new FileInputStream(f));
			if(json != null) {
				ArrayNode vendorDatas = (ArrayNode) json.get("CMDATA");
				if(vendorDatas != null) {
					for (JsonNode jsonNode : vendorDatas) {
						System.out.println(Convert.toJson(jsonNode));
					}
				}
			}
		}else {
			System.err.println("file not exists");
		}

	}
}
