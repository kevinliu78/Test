package com.kevin.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.kevin.util.ConfigUtil;

/**
 * @author kevin
 * @version 创建时间: 2018年10月15日下午3:22:11
 * @ClassName 类名称
 * @Description 类描述
 */
public class Test {
	private static final long PERIOD_DAY = 1000;
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15); //凌晨1点
        calendar.set(Calendar.MINUTE, 25);
        calendar.set(Calendar.SECOND, 34);
        Date date=calendar.getTime(); //第一次执行定时任务的时间
        //如果第一次执行定时任务的时间 小于当前的时间
        //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
        if (date.before(new Date())) {
        		Calendar startDT = Calendar.getInstance();
            startDT.setTime(date);
            startDT.add(Calendar.DAY_OF_MONTH, 1);
            date = startDT.getTime();
        }
        Timer timer = new Timer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				 System.out.println("我有一头小毛驴!"+ConfigUtil.formatDate24(new Date())); 
				
			}
		},date,PERIOD_DAY);
	}
}
