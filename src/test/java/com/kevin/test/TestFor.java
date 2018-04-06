package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年3月9日上午8:52:34
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFor {
	public static void main(String[] args) {
		int total = 5;
		for(int i=0,j=0;total>0;i++,j++) {
			total = total-i-j;
			System.out.println("======");
		}
	}
}
