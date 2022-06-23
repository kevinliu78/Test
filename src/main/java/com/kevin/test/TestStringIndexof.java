package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Dec 24, 20181:29:06 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringIndexof {
	public static void main(String[] args) {
		String s= "(106.120.84.194)-1545629473050_c445ec0c9cb6_11.235.242.39";
		String[] arr = s.split("_");
		// userId like "admin(192.168.11.131)-1823829839"
		String userId = arr[0];
		if(userId.contains("-")){
			userId = userId.substring(0, userId.indexOf("-"));
		}
		String cmMac = arr[1];
		System.out.println(userId+"====="+cmMac);

		String ss = "小明,小李,小赵,,,,";
		String s1 = testLastIndexOf(ss);
		System.out.println(s1);
	}

	private static String testLastIndexOf(String s){
		String substring = s.substring(0, s.lastIndexOf(","));
		return substring;
	}
}
