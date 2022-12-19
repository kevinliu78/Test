package com.kevin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: LWS
 * @Date: 2019/9/18 16:10
 */
public class DateFormatUtil {

  public static final long SECOND = 1000;
  public static final long MINUTE = SECOND * 60;
  public static final long HOUR = MINUTE * 60;
  public static final long DAY = HOUR * 24;

  private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  private static final SimpleDateFormat sdfDateTime24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static final SimpleDateFormat sdfDateTime24Short = new SimpleDateFormat("yyyyMMddHHmmss");
  private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
  private static final SimpleDateFormat sdfDateSimple = new SimpleDateFormat("M-d");
  private static final SimpleDateFormat sdfDateSimpleTime24 = new SimpleDateFormat("M-d HH:mm");
  private static final SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

  /**
   * 获取当日零点时间
   *
   * @return
   */
  public synchronized static Date getZeroDate() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    Date zero = calendar.getTime();
    return zero;
  }

  /**
   * 获取当日零点时间,字符串格式
   *
   * @return
   */
  public synchronized static String getZeroDateTime() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    Date zero = calendar.getTime();
    return formatDateTime24(zero);
  }

  /**
   * 获取过去24小时的时间,字符串格式
   *
   * @return
   */
  public synchronized static String getLast24HoursTime() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DATE, -1);
    Date date = calendar.getTime();
    return formatDateTime24(date);
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

  /**
   * 获取最近1月的时间
   *
   * @return
   */
  public synchronized static Date getZeroDateBeforeMonth() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.add(Calendar.DAY_OF_MONTH, -30);
    Date zero = calendar.getTime();

    return zero;
  }

  public synchronized static String formatUTCDate(String utcTime) throws ParseException {
    if (utcTime != null) {
      Date date = sdfUTC.parse(utcTime);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
      return formatDateTime24(calendar.getTime());
    }
    return null;
  }

  public synchronized static String formatDate(Date date) {

    if (date == null) {
      return null;
    }
    return sdfDate.format(date);
  }

  public synchronized static String formatDateSimple(Date date) {
    if (date == null) {
      return null;
    }
    return sdfDateSimple.format(date);
  }

  public synchronized static String formatDateTime(Date date) {
    if (date == null) {
      return null;
    }
    return sdfDateTime.format(date);
  }

  public synchronized static String formatDateTime24(Date date) {
    if (date == null) {
      return null;
    }
    return sdfDateTime24.format(date);
  }

  public synchronized static String formatDateTime24Short(Date date) {
    if (date == null) {
      return null;
    }
    return sdfDateTime24Short.format(date);
  }

  public synchronized static String formatDateSimpleTime24(Date date) {
    if (date == null) {
      return null;
    }
    return sdfDateSimpleTime24.format(date);
  }

  public synchronized static Date parseDate(String date) throws ParseException {
    if (date == null) {
      return null;
    }
    return sdfDate.parse(date);
  }

  public synchronized static Date parseDateTime(String date) throws ParseException {
    if (date == null) {
      return null;
    }
    return sdfDateTime.parse(date);
  }

  public synchronized static Date parseDateTime24(String date) {
    try {
      if (date == null) {
        return null;
      }
      return sdfDateTime24.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取指定时间半个小时前的时间
   *
   * @param time
   * @return
   */
  public synchronized static String getHalfHourBeforeTime(String time) {
    Date date = parseDateTime24(time);
    if (date != null) {
      long resultTime = date.getTime() - (30 * 60 * 1000L);
      String resultTimeStr = formatDateTime24(new Date(resultTime));
      return resultTimeStr;
    } else {
      return time;
    }
  }

  /**
   * 获取指定时间后一天的时间
   *
   * @param time
   * @return
   */
  public synchronized static String getAfterDayTime(String time) {
    Date date = parseDateTime24(time);
    if (date != null) {
      long resultTime = date.getTime() + (24 * 60 * 60 * 1000L);
      String resultTimeStr = formatDateTime24(new Date(resultTime));
      return resultTimeStr;
    } else {
      return time;
    }
  }

  /**
   * 获取指定时间半个小时后的时间
   *
   * @param time
   * @return
   */
  public synchronized static String getHalfHourAfterTime(String time) {
    Date date = parseDateTime24(time);
    if (date != null) {
      long resultTime = date.getTime() + (30 * 60 * 1000L);
      String resultTimeStr = formatDateTime24(new Date(resultTime));
      return resultTimeStr;
    } else {
      return time;
    }
  }

  /**
   * 获取指定某一天的开始时间
   *
   * @param time 时间 2021-11-10 17:55:00
   * @return
   */
  public static Long getDailyStartTime(String time) {
    try {
      Date date = parseDateTime24(time);
      if (date != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取指定某一天的结束时间戳
   *
   * @param time 时间 2021-11-10 17:55:00
   * @return
   */
  public static Long getDailyEndTime(String time) {
    try {
      Date date = parseDateTime24(time);
      if (date != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取当周开始时间戳
   *
   * @param time 时间 2021-11-10 17:55:00
   * @return
   */
  public static Long getWeekStartTime(String time) {
    try {
      Date date = parseDateTime24(time);
      if (date != null) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTime(date);
        int d = 0;
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
          d = -6;
        } else {
          d = 2 - dayOfWeek;
        }
        calendar.add(Calendar.DAY_OF_WEEK, d);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取当周结束时间戳
   *
   * @param time 时间 2021-11-10 17:55:00
   * @return
   */
  public static Long getWeekEndTime(String time) {
    try {
      Date date = parseDateTime24(time);
      if (date != null) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTime(date);
        int d = 0;
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
          d = -6;
        } else {
          d = 2 - dayOfWeek;
        }
        calendar.add(Calendar.DAY_OF_WEEK, d);
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取当月开始时间戳
   *
   * @param time 时间 2021-11-10 17:55:00
   * @return
   */
  public static Long getMonthStartTime(String time) {
    try {
      Date date = parseDateTime24(time);
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
        return calendar.getTimeInMillis();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取当月的结束时间戳
   *
   * @param time 时间 2021-11-10 17:55:00
   * @return
   */
  public static Long getMonthEndTime(String time) {
    try {
      Date date = parseDateTime24(time);
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
        return calendar.getTimeInMillis();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    Date zeroDateBeforeWeek = getZeroDateBeforeMonth();
    System.out.println(zeroDateBeforeWeek);
  }
}
