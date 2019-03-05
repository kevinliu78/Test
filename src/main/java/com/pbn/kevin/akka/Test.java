package com.pbn.kevin.akka;
/**
 *@author kevin
 *@version 创建时间: 2017年7月18日下午2:19:36
 */
public class Test {
//	static int i=1;
//	
//	int j = 2;
//	static {
//		System.out.println("aaaaaaaaaaaa");
//	}
//	public Test() {
//		System.out.println(j+"constructor");
//	}
//	
//	public void aaa(){
//		System.out.println(i+"bbbbbbbb");
//	}
//	
//	public static void print() {
//		System.out.println(i+"static");
//	}
	
	Class[] classArray = {  
            MyClass1.class//这样引用该类，必然需要将该类加载到虚拟机中  
    };
	
	public static void main(String[] args) {
//		MyClass1.print();
//		MyClass1 t = new MyClass1();
//		t.aaa();
//		t.print();
		System.out.println("hello");
	}
	
}

class MyClass1 {  
    
    static int i=1;
	
	int j = 2;
	static {
		System.out.println("aaaaaaaaaaaa");
	}
	public MyClass1() {
		System.out.println(j+"constructor");
	}
	
	public void aaa(){
		System.out.println(i+"bbbbbbbb");
	}
	
	public static void print() {
		System.out.println(i+"static");
	}
}  
