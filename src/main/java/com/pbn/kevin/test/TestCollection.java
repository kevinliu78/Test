package com.pbn.kevin.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author kevin
 * @version 创建时间: 2018年7月2日上午9:07:25
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestCollection {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("hello");
		System.out.println(c.size());
	}
}
