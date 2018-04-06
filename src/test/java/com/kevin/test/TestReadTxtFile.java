package com.kevin.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.kevin.utils.ConfigUtil;

/**
*@author kevin
*@version 创建时间: 2018年2月6日下午3:54:37
*/
public class TestReadTxtFile {
	public static void main(String[] args) throws Exception {
		readFileByLines("/Users/kevin/Desktop/snmpwalk/1802010855.txt");
	}
	
	public static void readFileByLines(String filename) throws Exception {
		File file = new File(filename);
		String name = file.getName();
		String parseString = parseString(name.substring(0, 10));
		Date date = ConfigUtil.parseDateTime(parseString);
		
		BufferedReader reader = null;
		try {
//			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			//一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				//显示行号
//				System.out.println("line"+line+": "+tempString);
				line ++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	public static String parseString(String s) {
		if(s!=null && s.length() ==10) {
			String y = s.substring(0, 2);
			String m = s.substring(2, 4);
			String d = s.substring(4, 6);
			String h = s.substring(6, 8);
			String M = s.substring(8, 10);
//			System.out.println("20"+y+"-"+m+"-"+d+" "+ h+":"+M);
			return "20"+y+"-"+m+"-"+d+" "+ h+":"+M+":00";
		}else if(s!=null && s.length() ==12) {
			String y = s.substring(0, 4);
			String m = s.substring(4, 6);
			String d = s.substring(6, 8);
			String h = s.substring(8, 10);
			String M = s.substring(10, 12);
//			System.out.println("20"+y+"-"+m+"-"+d+" "+ h+":"+M);
			return y+"-"+m+"-"+d+" "+ h+":"+M+":00";
		}
		return null;
	}
}
