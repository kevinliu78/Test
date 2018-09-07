package com.pbn.kevin.review;
/**
 * @author kevin
 * @version 创建时间: 2018年8月16日上午10:36:45
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestInfinity {
	public static final float POSITIVE_INFINITY = 1.0f / 0.0f;

	public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
	
	public static void main(String[] args) {
		System.out.println(Float.isNaN((POSITIVE_INFINITY * 0))); // output: true
		
		System.out.println(Float.isInfinite(POSITIVE_INFINITY)); // output: true
		System.out.println(Float.isInfinite(NEGATIVE_INFINITY)); // output: true
		System.out.println(Float.isInfinite(NEGATIVE_INFINITY)); // output: true
	}
}
