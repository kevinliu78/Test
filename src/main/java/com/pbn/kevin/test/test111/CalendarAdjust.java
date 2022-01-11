package com.pbn.kevin.test.test111;

import com.pbn.kevin.util.ConfigUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-11-09 15:41:09
 **/
public class CalendarAdjust {

    /**
     * 获取指定某一天的开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getDailyStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定某一天的开始时间
     *
     * @param time 毫秒级时间戳
     * @return
     */
    public static Long getDailyStartTime(String time) {
        try {
            Date date = ConfigUtil.parseDateTime24(time);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                long timeInMillis = calendar.getTimeInMillis();
                String s = ConfigUtil.formatDate24(new Date(timeInMillis));
                System.out.println("转换时间字符串：" + s);
                return timeInMillis;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定某一天的结束时间戳
     *
     * @param time 毫秒级时间戳
     * @return
     */
    public static Long getDailyEndTime(String time) {
        try {
            Date date = ConfigUtil.parseDateTime24(time);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                long timeInMillis = calendar.getTimeInMillis();
                String s = ConfigUtil.formatDate24(new Date(timeInMillis));
                System.out.println("转换时间字符串：" + s);
                return timeInMillis;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当周开始时间戳
     *
     * @param time 毫秒级时间戳
     * @return
     */
    public static Long getWeekStartTime(String time) {
        try {
            Date date = ConfigUtil.parseDateTime24(time);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();// 获取当前日期
                calendar.setTime(date);
                int d= 0;
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == 1){
                    d = -6;
                }else {
                    d = 2- dayOfWeek;
                }
                calendar.add(Calendar.DAY_OF_WEEK,d);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                long timeInMillis = calendar.getTimeInMillis();
                String s = ConfigUtil.formatDate24(new Date(timeInMillis));
                System.out.println("转换时间字符串：" + s);
                return timeInMillis;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当周结束时间戳
     *
     * @param time 毫秒级时间戳
     * @return
     */
    public static Long getWeekEndTime(String time) {
        try {
            Date date = ConfigUtil.parseDateTime24(time);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();// 获取当前日期
                calendar.setTime(date);
                int d= 0;
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == 1){
                    d = -6;
                }else {
                    d = 2- dayOfWeek;
                }
                calendar.add(Calendar.DAY_OF_WEEK,d);
                calendar.add(Calendar.DAY_OF_WEEK,6);
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                long timeInMillis = calendar.getTimeInMillis();
                String s = ConfigUtil.formatDate24(new Date(timeInMillis));
                System.out.println("转换时间字符串：" + s);
                return timeInMillis;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当月开始时间戳
     *
     * @param time 毫秒级时间戳
     * @return
     */
    public static Long getMonthStartTime(String time) {
        try {
            Date date = ConfigUtil.parseDateTime24(time);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();// 获取当前日期
                calendar.setTime(date);
                calendar.add(Calendar.YEAR, 0);
                calendar.add(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                long timeInMillis = calendar.getTimeInMillis();
                String s = ConfigUtil.formatDate24(new Date(timeInMillis));
                System.out.println("转换时间字符串：" + s);
                return timeInMillis;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当月的结束时间戳
     *
     * @param time 毫秒级时间戳
     * @return
     */
    public static Long getMonthEndTime(String time) {
        try {
            Date date = ConfigUtil.parseDateTime24(time);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();// 获取当前日期
                calendar.setTime(date);
                calendar.add(Calendar.YEAR, 0);
                calendar.add(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                long timeInMillis = calendar.getTimeInMillis();
                String s = ConfigUtil.formatDate24(new Date(timeInMillis));
                System.out.println("转换时间字符串：" + s);
                return timeInMillis;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定某一天的结束时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getDailyEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getMonthStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月的结束时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getMonthEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当年的开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getYearStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当年的最后时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getYearEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTimeInMillis();
    }

    /**
     * 时间戳转字符串
     *
     * @param timestamp 毫秒级时间戳
     * @param zoneId    如 GMT+8或UTC+08:00
     * @return
     */
    public static String timestampToStr(long timestamp, String zoneId) {
        ZoneId timezone = ZoneId.of(zoneId);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), timezone);
        return localDateTime.toString();
    }

    public static void main(String[] args) {
        String time = "2021-10-11 18:00:00";
        Long dailyStart = getDailyStartTime(time);
        Long dailyEnd = getDailyEndTime(time);
        System.out.println("Daily Start : " + dailyStart + ", Daily End : " + dailyEnd + "; ");

        Long weekStart = getWeekStartTime(time);
        Long weekEnd = getWeekEndTime(time);
        System.out.println("Week Start : " + weekStart + ", Week End : " + weekEnd + "; ");

        Long monthStart = getMonthStartTime(time);
        Long monthEnd = getMonthEndTime(time);
        System.out.println("Month Start : " + monthStart + ", Month End : " + monthEnd + "; ");
    }
}