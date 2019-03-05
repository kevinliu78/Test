package com.pbn.kevin.test;

import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.message.OpCode;
import com.nms.message.result.CResult;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年9月25日下午1:32:33
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringBytes {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(cmNode().getBytes("UTF-8").length);
	}
	public static String cmNode() {
		CResult<JsonNode> result = new CResult<JsonNode>(OpCode.FAILURE.toString(), null, Convert.newObject(), "");
		ObjectNode data = Convert.newObject();
		data.put("cmtsIp", "10.177.0.1");
		data.put("mac", "4e5f6a1b2c3d");
		data.put("ip", "10.177.18.248");
		data.put("cmIndex", 1483);
		data.put("cmStatus", 1);
		data.put("cmUpSnr", 26.5);
		data.put("cmUpIfIndex", 1998783492);
		data.put("cmDownIfIndex", 2032337921);
		data.put("updateTime", "2018-09-13 10:11:53");
		data.put("isFBCEnable", 1);
		data.put("downChannelId", 1);
		data.put("downFrequency", 291);
		data.put("downWidth", 8);
		data.put("downModulation", 3);
		data.put("rxPower", 2.5);
		data.put("downSnr", 45.4);
		data.put("upChannelId", 1);
		data.put("upFrequency", 45);
		data.put("upWidth", 3.2);
		data.put("upModulation", 0);
		data.put("txPower", 46.7);
		data.put("fecUnerr", 1);
		data.put("fecCorerr", 3064);
		data.put("fecUncorerr", 75);
		data.put("systemDescr", "JiangsuYitong DCM <<HW_REV: V1.0; FW_REV: 3.2.1.0_hrb ;VENDOR: JiangsuYitong; BOOTR: 2.4.0beta4; SW_REV: 3.2.1.0_hrb; MODEL: YTCM-5112-30>>");
		data.put("preEqData", "08:01:18:00:00:20:00:00:ff:b0:00:30:00:30:00:20:ff:e0:00:20:ff:a0:ff:f0:00:60:00:20:ff:50:ff:70:7f:f0:00:00:00:a0:00:40:00:10:ff:c0:00:10:00:40:00:00:ff:e0:00:40:00:00:00:20:ff:d0:00:30:00:00:ff:f0:00:10:00:00:ff:f0:ff:e0:ff:f0:00:20:00:10:00:00:ff:c0:ff:d0:ff:c0:00:00:00:10:00:00:ff:e0:00:10:ff:f0");
		data.put("sysUpTime", 148798100);
		data.put("vendorId", "1.3.6.1.4.1.4413.2.1.2.1.3383");
		data.put("customerName", "a");
		data.put("customerAddress", "a");
		data.put("customerPhone", "a");
		data.put("businessType", "1");
		data.put("mer", 45.4);
		ObjectNode extData = Convert.newObject();
		ArrayNode upList = extData.putArray("upList");
		ObjectNode node1 = Convert.newObject();
		node1.put("index",4);
		node1.put("cmtsIndex",1998783489);
		node1.put("channelId",1);
		node1.put("snr",31.2);
		node1.put("frequency",45);
		node1.put("width",3.2);
		node1.put("modulation",0);
		node1.put("preEqData","08:01:18:00:00:20:00:00:ff:b0:00:30:00:30:00:20:ff:e0:00:20:ff:a0:ff:f0:00:60:00:20:ff:50:ff:70:7f:f0:00:00:00:a0:00:40:00:10:ff:c0:00:10:00:40:00:00:ff:e0:00:40:00:00:00:20:ff:d0:00:30:00:00:ff:f0:00:10:00:00:ff:f0:ff:e0:ff:f0:00:20:00:10:00:00:ff:c0:ff:d0:ff:c0:00:00:00:10:00:00:ff:e0:00:10:ff:f0");
		node1.put("txPower",46.7);
		ObjectNode node2 = Convert.newObject();
		node2.put("index",81);
		node2.put("cmtsIndex",1998783490);
		node2.put("channelId",2);
		node2.put("snr",26.5);
		node2.put("frequency",41);
		node2.put("width",3.2);
		node2.put("modulation",0);
		node2.put("preEqData","08:01:18:00:00:00:00:10:ff:d0:00:20:00:00:ff:f0:ff:f0:00:50:ff:f0:ff:f0:00:30:00:30:ff:c0:ff:30:7f:f0:00:00:fe:50:00:90:00:40:ff:70:ff:b0:00:30:ff:d0:ff:c0:00:30:00:00:ff:e0:ff:f0:00:50:00:20:ff:c0:00:00:00:10:ff:e0:ff:f0:00:10:00:20:00:10:00:10:00:00:ff:e0:00:10:00:20:ff:d0:ff:f0:00:20:00:10:ff:e0");
		node2.put("txPower",46.9);
		ObjectNode node3 = Convert.newObject();
		node3.put("index",80);
		node3.put("cmtsIndex",1998783492);
		node3.put("channelId",4);
		node3.put("snr",36.7);
		node3.put("frequency",61);
		node3.put("width",3.2);
		node3.put("modulation",0);
		node3.put("preEqData","08:01:18:00:00:20:00:00:ff:90:00:00:00:10:ff:f0:00:00:00:40:ff:f0:ff:70:00:50:00:c0:ff:80:fe:20:7f:f0:00:00:ff:c0:01:40:ff:c0:ff:a0:ff:d0:00:30:ff:c0:ff:d0:00:00:00:10:ff:d0:ff:e0:00:30:00:10:ff:c0:00:00:00:30:ff:f0:ff:d0:ff:f0:00:00:ff:c0:ff:e0:ff:f0:ff:c0:ff:e0:00:10:00:10:00:00:00:10:00:00:ff:f0");
		node3.put("txPower",47.4);
		
		upList.add(node1);
		upList.add(node2);
		upList.add(node3);
		
		data.set("extData", extData);
		result.success(data, "successful");
		return result.toJson();
	}
}
