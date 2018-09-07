package com.kevin.test;

import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年6月28日上午11:03:57
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestObjectNode {
	public static void main(String[] args) {
		A a = new A("aaa", 1);
		String json = Convert.toJson(a);
		System.out.println(json);
	}
}

class A {
	private final String clientKey;
	private final int currentPort; //current FBC port
	public A(String clientKey, int currentPort)
	{
		this.clientKey = clientKey;
		this.currentPort = currentPort;
	}


	public String getClientKey() {
		return clientKey;
	}	

	public String getMessageName() {
		return "WssFBCPollingDirectResponse";
	}

	public int getCurrentPort() {
		return currentPort;
	}
}
