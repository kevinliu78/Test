package com.pbn.kevin.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: LWS
 * @Date: 2020/8/14 16:09
 */
public class TestLast24HoursTime {

    private static final SimpleDateFormat sdfDateTime24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        String s = formatDateTime24(getZeroDateBeforeMonth());
//        System.out.println(s);
//        Date zeroDateBeforeMonth = getZeroDateBeforeMonth();
//        long dayTime = (24 * 60 * 60 * 1000L);
//        long monthTime = (24 * 60 * 60 * 1000L)*30;
//        long a = System.currentTimeMillis() - monthTime;
//        long b = System.currentTimeMillis() - a;
//        System.out.println(b<=monthTime);
//        System.out.println(b/dayTime);
//        System.out.println(b%dayTime);
//        System.out.println(formatDateTime24(new Date(System.currentTimeMillis())));
//
//        long currentTimeMillis = System.currentTimeMillis();
//        long end = currentTimeMillis;
//        long start = (currentTimeMillis - (60 * 60 * 1000L));
//        System.out.println(formatDateTime24(new Date(start)));
//        System.out.println(formatDateTime24(new Date(end)));
//        start = (start/(5*60*1000)) * (5*60*1000);
//        end = (end/(5*60*1000)) * (5*60*1000);
//        System.out.println("=====================================");
//        System.out.println(formatDateTime24(new Date(start)));
//        System.out.println(formatDateTime24(new Date(end)));
        Date zeroDateBeforeWeek = getZeroDateBeforeWeek();
        System.out.println(formatDateTime24(zeroDateBeforeWeek));
    }

    /**
     * 获取当日零点时间,字符串格式
     *
     * @return
     */
    public synchronized static String getLast24HoursTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date date = calendar.getTime();
        return formatDateTime24(date);
    }

    public synchronized static String formatDateTime24(Date date) {
        if (date == null) {
            return null;
        }
        return sdfDateTime24.format(date);
    }

    /**
     * 获取最近1月的时间
     *
     * @return
     */
    public synchronized static Date getZeroDateBeforeMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date zero = calendar.getTime();

        return zero;
    }

    /**
     * 获取最近七天的时间
     *
     * @return
     */
    public synchronized static Date getZeroDateBeforeWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -6);
        Date zero = calendar.getTime();

        return zero;
    }
}
