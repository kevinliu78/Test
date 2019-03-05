package com.pbn.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Oct 24, 20189:55:02 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringMatch {
	public static void main(String[] args) {
		String a = ".*[a-fA-F0-9].*";
		String c = "^[0-9a-fA-F]+$";
		String b = "^[0-9a-fA-F]{5,12}+$";
		System.out.println("12.3".contains("."));
	}
}
