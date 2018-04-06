package com.kevin.test.thread;
/**
 * @author kevin
 * @version 创建时间: 2018年3月8日下午3:10:23
 * @ClassName 类名称
 * @Description 类描述
 */
public class Test1 extends Thread {
	int count = 0;
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("第"+ ++count +"遍执行");
		}
	}
	
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.start();
	}
	
}
