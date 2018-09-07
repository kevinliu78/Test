package com.pbn.kevin.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年7月31日上午8:54:27
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestSort {
	public static void main(String[] args) {
//		String mtrStr = "";
//		String upFreqStr = "50.2,31,37.4,43.8";
//		String minMtrUpFreq = getMinMtrUpFreq(upFreqStr, mtrStr);
//		System.out.println(minMtrUpFreq);
		
		
		
		
		testArrayNodeSort();
	}
	public static String getMinMtrUpFreq(String upFreqStr,String mtrStr) {
		if(upFreqStr != null && !upFreqStr.isEmpty() && mtrStr != null && !mtrStr.isEmpty()) {
			String[] mtrArr = mtrStr.split(",");
			String min = mtrArr[0];int pos = 0;
			for(int i = 0; i<mtrArr.length; i++) {
				if(Float.parseFloat(mtrArr[i])<Float.parseFloat(min)) {
					min = mtrArr[i];
					pos = i;
				}
			}
			return upFreqStr.split(",")[pos];
		}
		return null;
	}
	
	
	
	public static void testArrayNodeSort() {
		ObjectNode response = Convert.newObject();
		List<ObjectNode> mutliChannel =  new ArrayList<ObjectNode>();
		String upFreqStr = "61,41,45,37";
		if(upFreqStr != null && !upFreqStr.isEmpty()) {
			String[] upFreqArr = upFreqStr.split(",");
			String newUpFreq = upFreqArr[3];
			response.put("usFrequency", upFreqArr[1]);
			for(int i = 0; i<upFreqArr.length; i++) {
				ObjectNode channelNode = Convert.newObject();
				channelNode.put("upFreq", upFreqArr[i]);
				channelNode.put("checked", false);
				if(newUpFreq.equals(upFreqArr[i])) {
					channelNode.put("checked", true);
				}
				mutliChannel.add(channelNode);
			}
		}
		
		if(mutliChannel != null && mutliChannel.size()>1) {
			Collections.sort(mutliChannel,(o1,o2) -> {	
				return new Float(Float.parseFloat(o1.get("upFreq").asText())).compareTo(new Float(Float.parseFloat(o2.get("upFreq").asText())));
			});
		}
		response.putPOJO("mutliChannel", mutliChannel);
		System.out.println(Convert.toJson(response));
	}
}
