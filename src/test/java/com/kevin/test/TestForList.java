package com.kevin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 创建时间: 2018年5月30日下午9:21:29
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestForList {
	public static void main(String[] args) {
		List<List<String>> testLists = new ArrayList<List<String>>();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		list1.add("a1");
		list1.add("b1");
		list1.add("c1");
		
		list2.add("a2");
		list2.add("b2");
		list2.add("c2");
		
		list4.add("a4");
		list4.add("b4");
		list4.add("c4");
		
		testLists.add(list1);
		testLists.add(list2);
		testLists.add(list3);
		testLists.add(list4);
		
		for (List<String> l : testLists) {
			for (String string : l) {
				System.out.println(string);
			}
		}
	}
}
