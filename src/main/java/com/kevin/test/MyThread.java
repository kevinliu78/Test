	package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年7月12日下午2:10:07
 * @ClassName 类名称
 * @Description 类描述
 */
public class MyThread implements Runnable {
	
	private String name;
	private Object prev;
	private Object self;

	public MyThread(String name, Object prev, Object self) {
		this.name=name;
		this.prev=prev;
		this.self=self;
	}
	
	@Override
	public void run() {

		int count = 10;
		while(count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.print(name);
					count--;
					
					self.notify();
				}
				try {
					prev.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		MyThread pa = new MyThread("A", c, a);
		MyThread pb = new MyThread("B", a, b);
		MyThread pc = new MyThread("C", b, c);
		new Thread(pa).start();
		Thread.sleep(100);
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
	}
	
}
