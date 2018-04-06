package com.kevin.test;
import java.io.File;
import java.util.Date;

import com.kevin.utils.ConfigUtil;


/**
*@author kevin
*@version 创建时间: 2018年1月22日上午9:16:40
*/
public class TestCreateFile {

	
	public static void main(String[] args) {
		String filePath = "doc" + File.separator + "loginlog_"
				+ ConfigUtil.formatDateTime(new Date()) + ".xls";

		File file = new File(filePath);
		if (!file.getParentFile().exists()) { // 文件目录不存在
			file.getParentFile().mkdirs(); // 创建目录
		}
//		File f = new File("doc/test1.txt");
//		file.mkdir();
		System.out.println("11111111==========="+file.getPath());
		try {
			file.createNewFile();
//			if(f.exists()){
//				f.delete();
//			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
