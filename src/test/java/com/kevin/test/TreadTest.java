package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年3月7日下午4:33:30
 * @ClassName 类名称
 * @Description 类描述
 */
public class TreadTest extends Thread {
	
	int count = 10;

	@Override
	public void run() {
		while(true) {
			System.out.print(count+"\t");
			if(--count == 0) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		TreadTest tt = new TreadTest();
		tt.start();
	}
	
	
}
