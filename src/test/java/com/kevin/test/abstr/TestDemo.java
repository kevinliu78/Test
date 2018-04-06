package com.kevin.test.abstr;
/**
 * @author kevin
 * @version 创建时间: 2018年3月8日上午11:22:35
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestDemo {
	
	public static void main(String[] args) {
		TestAbstract t = new TestAbstractImpl();
		t.aa();
		t.bb();
		t.hello();
		System.out.println("test======");
	}
}
