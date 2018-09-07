package com.kevin.test.thread;
/**
 * @author kevin
 * @version 创建时间: 2018年3月8日下午2:44:45
 * @ClassName 类名称
 * @Description 类描述
 */
public class ThreadSafeTest implements Runnable {

	int num = 10;
	
	@Override
	public void run() {
		while (true) {
			doIt();
		}
	}
	
	public synchronized void doIt() {
		if(num > 0) {
			try {
				System.out.println("进入休眠态--------------------------------");
				Thread.sleep(100);
				System.out.println("进入运行态--------------------------------");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("剩余票张数："+ --num);
		}
	}
	
	public static void main(String[] args) {
		ThreadSafeTest t = new ThreadSafeTest();
		Thread threadA = new Thread(t);
		Thread threadB = new Thread(t);
		Thread threadC = new Thread(t);
		Thread threadD = new Thread(t);
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
	}

}
