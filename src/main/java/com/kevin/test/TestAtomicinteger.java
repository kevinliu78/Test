package com.kevin.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kevin
 * @version 创建时间: Dec 14, 20181:34:28 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestAtomicinteger {
	public static void main(String[] args) {

		AtomicInteger keywordRuleSize = new AtomicInteger(0);
		keywordRuleSize.incrementAndGet();
		System.out.println(keywordRuleSize.get());

		AtomicInteger cmCountInPNMActor = new AtomicInteger(2147483647);
		System.out.println(cmCountInPNMActor.get());
		for (int i = 0; i < 10; i++) {
			cmCountInPNMActor.incrementAndGet();
			System.out.println(cmCountInPNMActor.get());
		}


		System.out.println(3560*2);
		System.out.println(3854*6);
		System.out.println(1606*5);
		System.out.println(3560*2+3854*6+1606*5);
	}
}
