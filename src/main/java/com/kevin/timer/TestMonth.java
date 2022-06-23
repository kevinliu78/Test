package com.kevin.timer;
/**
 * @author kevin
 * @version 创建时间: Jan 11, 20192:04:31 PM
 * @ClassName 类名称
 * @Description 类描述
 */

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class TestMonth {

	public static void main(String[] args) {
		// 设置TimerTask
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int day = calendar.get(Calendar.DATE);
				System.out.println("year" + year);
				System.out.println("month-1===" + (month - 1));
				System.out.println("day==" + day);
				calendar.set(Calendar.YEAR, year);
				calendar.set(Calendar.MONTH, (month));
				int end = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
				int begin = calendar.getActualMinimum(calendar.DAY_OF_MONTH);
				System.out.println("当前月第一天：" + begin + "--------" + "当前月份最后一天：" + end + "现在是几号：" + day);
				if (end == day) {
					// 是本月最后一天执行计算代码(未完成)
					System.out.println("success");
				} else {
					System.out.println("false");
				}
			}
		};
		task.run();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);// 年份
		int month = cal.get(Calendar.MONTH);// 上个月份
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date end = cal.getTime(); // 本月头
		cal.add(Calendar.MONTH, -1);
		Date start = cal.getTime();// 上月头
		double monthDay = cal.getActualMaximum(Calendar.DATE);
		System.out.println(year);
		System.out.println(month-1);
		System.out.println(end);
		System.out.println(start);
		System.out.println(monthDay);
	}

}
