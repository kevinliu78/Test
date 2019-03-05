package com.pbn.kevin.test;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年10月8日下午4:02:28
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestObjectNode {
	public static void main(String[] args) {
		ObjectNode node = Convert.newObject();
		node.put("aaa", "-0.1");
		System.out.println(node.get("aaa").floatValue());
		
		ArrayNode mutliChannel = Convert.newObject().arrayNode();
		String hUpFreqStr = "0,52,98";
		String[] hUpFreqArr = hUpFreqStr.split(",");
		for(int i = 0; i< hUpFreqArr.length; i++) {
			ObjectNode channelNode = Convert.newObject();
			if(Integer.parseInt(hUpFreqArr[i])==0) {
				System.out.println("wei 0");
				continue;
			}
				
			channelNode.put("upFreq", hUpFreqArr[i]);
			channelNode.put("checked", false);
			mutliChannel.add(channelNode);
		}
		
		System.out.println(Convert.toJson(mutliChannel));
	}
}
