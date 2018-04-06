package com.kevin.test;

/**
*@author kevin
*@version 创建时间: 2018年2月7日下午3:08:48
*/
public class TestString {
	public static void main(String[] args) {
		String oid = "1.3.6.1.2.1.10.127.1.3.5.1.4.2.1";
		String modProfile = oid.substring(DocsisSNMPConstant.docsIfCmtsModType.length()+1);
		int modProfileId = Integer.parseInt(modProfile.split("\\.")[0]);
		int modUsageCode = Integer.parseInt(modProfile.split("\\.")[1]);
		System.out.println(modProfileId+";;;;;;"+modUsageCode);
	}
}
