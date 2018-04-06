package com.kevin.test.socket;
/**
 * @author kevin
 * @version 创建时间: 2018年3月23日上午9:44:47
 * @ClassName 类名称
 * @Description 类描述
 */
public class Test {
	public static void main(String[] args) {
		int j = 72;
		double spanLive = 0.12;
//	　　　　　　"(j/24)*spanLive====":0.35999998
		System.out.println(3*spanLive);
		
		long t1 = 1521770824089l;
		long t2 = 1521770824123l;
		System.out.println(t2-t1);
		String s = "64D3";
		float a = Integer.valueOf(s,16);
		System.out.println("a==="+a/1000);
	}
}
