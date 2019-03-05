package com.pbn.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Nov 30, 201810:18:43 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestLong {
	private static long a;
	public static void main(String[] args) {
		System.out.println(a);
		for (int i = 5; i < 10; i++) {
			if(a == 0l) {
				a=i;
			}
		}
		System.out.println(a);
	}
}
