package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年3月7日下午4:33:30
 * @ClassName 类名称
 * @Description 类描述
 */
public class TreadTest2 implements Runnable {
	long count = 100000000l;
	char s = '1';
	@Override
	public void run() {
		while(true) {
//			System.out.print(count+" ");
//			System.out.println();
			if(--count == 0) {
				System.out.println(s);
				return;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		TreadTest2 tt = new TreadTest2();
		tt.run();
		long t2 = System.currentTimeMillis();
		System.out.println("run time : "+(t2-t1)+"ms");
	}
	
	
}
