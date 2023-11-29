package com.kevin;

import com.kevin.util.DateFormatUtil;
import org.apache.poi.util.NullLogger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-11-09 14:52:02
 **/
public class TestDate {

    private static final SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private static final SimpleDateFormat sdfDateTime24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        try {
            String time = "2019-10-18T00:00:00Z";
            System.out.println(formatUTCDate(time));

            String startTime = "2023-07-10 15:17:00";
            String endTime = "2023-11-10 16:17:00";
            long dayTime = (24 * 60 * 60 * 1000L);
            Date startDate = DateFormatUtil.parseDateTime24(startTime);
            Date endDate = DateFormatUtil.parseDateTime24(endTime);
            long start = startDate.getTime();
            long end = endDate.getTime();
            long timeInterval = (endDate.getTime() - startDate.getTime());
            long day = timeInterval / dayTime;
            int interval = 5;
            if (day >= 0 && day <= 1) {
                interval = 1;
            } else if (day > 1 && day <= 7) {
                interval = 30;
            } else if (day > 7 && day <= 30) {
                interval = 120;
            } else if (day > 30 && day <= 90) {
                interval = 360;
            } else {
                interval = 1440;
            }
            interval = 30;
            System.out.println(interval);
//            start = (start / (interval * 60 * 1000)) * (interval * 60 * 1000);
//            end = (end / (interval * 60 * 1000)) * (interval * 60 * 1000) + 1000;

            start = (start / (60 * 1000)) * (60 * 1000);
            end = (end / (60 * 1000)) * (60 * 1000) + 1000;

//            int secInterval = 1800;
//            start = (start / (secInterval * 1000)) * (secInterval * 1000);
//            end = (end / (secInterval * 1000)) * (secInterval * 1000) + 1000;

            System.out.println(new Date(start));
            System.out.println(new Date(end));

            System.out.println("aa".equals(null));
            Integer a = 20001;
            Integer b = 20001;
            System.out.println(a.equals(b));
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public synchronized static String formatDateTime24(Date date) {
        if (date == null) {
            return null;
        }
        return sdfDateTime24.format(date);
    }
}
