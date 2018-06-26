package com.kevin.test;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author kevin
 * @version 创建时间: 2018年5月18日上午11:05:10
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestTimeToString {
	private static final SimpleDateFormat sdfDateTime24 = new SimpleDateFormat("yyyy-MM-dd_HH");
	private static long date1 = 1526601600000l;
	private static long date2 = 1526605200000l;
	private static long date3 = 1526608800000l;
	public static void main(String[] args) {
		String s1 = formatDate24(new Date(date1));
		String s2 = formatDate24(new Date(date2));
		String s3 = formatDate24(new Date(date3));
		String sc = formatDate24(new Date());
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(sc);
		
		String substring = s1.substring(s1.length()-2, s1.length());
		System.out.println(Integer.valueOf(substring));
		
		
		System.out.println("=======Float convert====="+Float.parseFloat("0.0"));
	}
	
	public static String formatDate24(Date date)
	{

		if(date == null)
			return null;

		return sdfDateTime24.format(date);
	}
}
