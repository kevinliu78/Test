package com.pbn.kevin.timer;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kevin
 * @version 创建时间: Jan 11, 20193:31:05 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class CalendarDemo {
	Calendar calendar = null;

	@Before
	public void test() {
		calendar = Calendar.getInstance();
	}

	// 基本用法，获取年月日时分秒星期
	@Test
	public void test1() {
		// 获取年
		int year = calendar.get(Calendar.YEAR);

		// 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
		int month = calendar.get(Calendar.MONTH) + 1;

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day_date = calendar.get(Calendar.DATE);
		System.out.println(day_date);
		// 获取时
		int hour = calendar.get(Calendar.HOUR);
		// int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示

		// 获取分
		int minute = calendar.get(Calendar.MINUTE);

		// 获取秒
		int second = calendar.get(Calendar.SECOND);

		// 星期，英语国家星期从星期日开始计算
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);

		System.out.println("现在是" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒"
				+ "星期" + weekday);
	}

	// 一年后的今天
	@Test
	public void test2() {
		// 同理换成下个月的今天calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.YEAR, 1);

		// 获取年
		int year = calendar.get(Calendar.YEAR);

		// 获取月
		int month = calendar.get(Calendar.MONTH) + 1;

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.println("一年后的今天：" + year + "年" + month + "月" + day + "日");
	}

	// 获取任意一个月的最后一天
	@Test
	public void test3() {
		// 假设求6月的最后一天
		int currentMonth = 6;
		// 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
		// 1
		calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

		calendar.add(Calendar.DATE, -1);

		// 获取日
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.println("6月份的最后一天为" + day + "号");
	}

	// 设置日期
	@Test
    public void test4() {
        calendar.set(Calendar.YEAR, 2000);
        System.out.println("现在是" + calendar.get(Calendar.YEAR) + "年");

        calendar.set(2008, 8, 8);
        // 获取年
        int year = calendar.get(Calendar.YEAR);

        // 获取月
        int month = calendar.get(Calendar.MONTH);

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("现在是" + year + "年" + month + "月" + day + "日");
    }

	// 获取前一天时间字符串
	@Test
	public void test5() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE,-1);
		Date time = calendar.getTime();
		System.out.println("today================" + df.format(date));
		System.out.println("yesterday================" + df.format(time));
		String ss = "24H";
		System.out.println(ss.indexOf("H"));
		System.out.println(ss.substring(0,ss.indexOf("H")));

		double mv = 5.7546d;
		DecimalFormat df11 = new DecimalFormat("#.00");
		System.out.println(Double.parseDouble(df11.format(mv)));

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(new Date());
		calendar1.set(Calendar.HOUR_OF_DAY, 0);
		calendar1.set(Calendar.MINUTE, 0);
		calendar1.set(Calendar.SECOND, 0);
		calendar1.add(Calendar.DAY_OF_YEAR,-7);
		Date zero = calendar1.getTime();
		long time1 = zero.getTime();
		for (int i=0;i<7;i++){
			System.out.println(df.format(new Date(time1)));
			time1+=(24*60*60*1000L);
			System.out.println(df.format(new Date(time1)));
			System.out.println("===================================================");
		}

		System.out.println(zero);
	}
}
