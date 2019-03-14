package com.pbn.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Mar 5, 20195:41:01 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestDouble {
	public static void main(String[] args) {
		double startFreq = 997.6;
		double space = 0.025;
		for (int i = 0; i < 10; i++) {
			System.out.println(startFreq+i*space);
		}
		double d1 = 997.65;
		System.out.println(3*space);
	}
}
