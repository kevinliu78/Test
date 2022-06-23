package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年7月6日上午10:38:32
 * @ClassName 类名称
 * @Description 类描述
 */
public class Test111 {
	public static void main(String[] args) {
		Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.level = 9;
		t2.level = 47;
		t1 = t2;
		
		t1.level = 27;
		System.out.println("t1.level:"+t1.level+",t2.level="+t2.level);
		
		String s= "08 01 18 00 00 11 00 24 ff d1 00 3e 00 53 ff f0 ff db 00 46 00 6f ff d8 ff 15 00 5b 01 df ff 01 7f f1 00 00 fd a3 00 b6 01 0e ff c9 ff 6e 00 42 00 30 ff ca ff b1 00 42 00 0f ff f9 ff e5 00 07 00 28 00 04 00 21 ff ec 00 21 00 00 00 2e 00 3c 00 16 00 12 00 3c 00 1d 00 0e 00 57 00 02 00 05 00 4e 00 34";
		System.out.println(s.replace(" ", ":"));
	}
}

class Tank {
	int level;
}