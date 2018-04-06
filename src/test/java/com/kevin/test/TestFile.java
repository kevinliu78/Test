package com.kevin.test;

import java.io.File;

/**
 * @author kevin
 * @version 创建时间: 2018年3月28日下午3:56:36
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFile {
	public static void main(String[] args) throws Exception {
		String filePath = "doc/histoy.txt";
		File file = new File(filePath);
		if(file.exists()) {
			System.out.println("wenjiancunzai!!!");
			file.delete();
		}
//		else {
//			System.out.println("wenjian========bucunzai!!!");
//			file.createNewFile();
//		}
		
	}
}
