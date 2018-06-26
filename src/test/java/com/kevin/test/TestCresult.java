package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年6月22日上午9:58:19
 * @ClassName 类名称
 * @Description 类描述
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.message.OpCode;
import com.nms.message.result.CResult;
import com.nms.util.Convert;

public class TestCresult {
	public static void main(String[] args) {
		CResult<JsonNode> cresult = cresult();
		String json = Convert.toJson(cresult);
		JsonNode jsonNode = Convert.parse((String)(json));
		System.out.println(jsonNode);
		if(jsonNode.has("header")) {
			System.out.println((jsonNode.get("header").get("opCode").asText().equals("1")));
			if(jsonNode.get("header").get("opCode").asText().equals("1")) {
				System.out.println(jsonNode.get("body").get("data"));
			}
		}
	}
	
	public static CResult<JsonNode> cresult(){
		CResult<JsonNode> result = new CResult<JsonNode>(OpCode.SUCCESS.toString(), "", Convert.newObject(), "success");
		ObjectNode node = Convert.newObject();
		node .put("name", "aaaa");
		node .put("age", 18);
		result.success(node, "success");
		return result;
	}
}
