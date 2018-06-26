package com.kevin.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

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
public class TestFile1 {
	public static void main(String[] args) throws Exception {
		String filePath = "doc/odnchannel.json";
		String filePath1 = "doc/cm_icfr_data.txt";
		File outdatafile = new File(filePath1);
		if(!outdatafile.exists()){
			outdatafile.createNewFile();
		}
		FileOutputStream cmout = new FileOutputStream(outdatafile);
		BufferedWriter cmwriter = new BufferedWriter(new OutputStreamWriter(cmout));
		File f = new File(filePath);
		if(f.exists()) {
			ObjectNode json = (ObjectNode) Convert.parse(new FileInputStream(f));
			if(json != null) {
				ArrayNode indata = (ArrayNode)json.get("body").get("data").get("list");
				for (JsonNode jsonNode : indata) {
					String mac = jsonNode.get("mac").asText();
					ArrayNode inchannel = (ArrayNode)jsonNode.get("inChannel");
					String text = mac+",";
					for (int i = 0;i<inchannel.size();i++) {
						JsonNode j = inchannel.get(i).get(1);
						if(i==(inchannel.size()-1)) {
							text+=Convert.toJson(j);
						}else {
							text+=Convert.toJson(j)+",";
						}
					}
					cmwriter.write(text);	  		 			
	 			 	cmwriter.newLine();
				}
				cmwriter.close();
			}
		}else {
			System.err.println("file not exists");
		}

	}
}
