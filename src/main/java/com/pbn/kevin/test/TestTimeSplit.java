package com.pbn.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Dec 11, 201811:02:07 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestTimeSplit {
	public static void main(String[] args) {
		String timeStr = "12:30:00";
		String[] split = timeStr.trim().split(":");
		int hour = Integer.parseInt(split[0]);
		int minute = Integer.parseInt(split[1]);
		int second = Integer.parseInt(split[2]);
		int hour1 = hour;
		int minute1 = minute;
		if(minute1-50<0) {
			minute1 = minute1+10;
			hour1 = hour1-1;
		}else {
			minute1 = minute1-50;
		}
		System.out.printf("%s:%s:%s \n",hour,minute,second);
		System.out.printf("%s:%s:%s \n",hour1,minute1,second);
	}
}
