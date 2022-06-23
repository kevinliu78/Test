package com.kevin.test;

/**
 * @author kevin
 * @version 创建时间: 2018年7月2日下午4:37:11
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestVolatile {
	boolean status = false;

	/**
	 * 状态切换为true
	 */
	public void changeStatus() {
		status = true;
	}

	/**
	 * 若状态为true，则running。
	 * 
	 * @throws InterruptedException
	 */
	public void run1() {
		if (status) {
			System.out.println("running....");
		} else {
			System.out.println("not running....");
		}
	}

	public void test() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				changeStatus();

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				run1();
				

			}
		}).start();
	}

	public static void main(String[] args) {
		TestVolatile t = new TestVolatile();
		t.test();
	}
}

class A extends Thread {

	@Override
	public void run() {
		TestVolatile t = new TestVolatile();
		t.changeStatus();
	}

}

class B extends Thread {
	@Override
	public void run() {
		TestVolatile t = new TestVolatile();
		t.run1();
	}
}
