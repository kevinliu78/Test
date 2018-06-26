package com.kevin.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年6月5日下午3:05:33
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFile2 {
	public static void main(String[] args) throws Exception {
		String filePath = "doc/odnchannel.json";
		String filePath2 = "doc/odnchannel1.json";
		String filePath1 = "doc/bbb.json";
		File outdatafile = new File(filePath2);
		if(!outdatafile.exists()){
			outdatafile.createNewFile();
		}
		File f = new File(filePath);
		File f1 = new File(filePath1);
		if(f.exists()) {
			ObjectNode json = (ObjectNode) Convert.parse(new FileInputStream(f));
			ObjectNode json1 = (ObjectNode) Convert.parse(new FileInputStream(f1));
			if(json != null) {
				ArrayNode indata = (ArrayNode)json.get("body").get("data").get("list");
				for (JsonNode jsonNode : indata) {
					String mac = jsonNode.get("mac").asText();
					String asText = json1.get(mac)==null?"1":json1.get(mac).asText();
					((ObjectNode) jsonNode).put("type",asText);
				}
				FileOutputStream fos = new FileOutputStream(filePath2);
				JsonUtil.write(fos, json);
				fos.close();
			}
		}else {
			System.err.println("file not exists");
		}

	}
}
