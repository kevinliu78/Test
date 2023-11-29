package com.kevin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-08-15 11:12:04
 **/
public class TestJinJingZheng {

    public static void main(String[] args) {
        int remainDays = parseRemainDaysOfDate(new Date());
        int jinJingZhengRemainDays = 9*7;
        int i = remainDays/jinJingZhengRemainDays;
        System.out.println(i);
    }

    public static int parseRemainDaysOfDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        return actualMaximum - dayOfYear;
    }


    public static int parseRemainDays(String strDate){
        if(strDate==null || strDate.isEmpty() || strDate.length()<10){
            return -1;
        }
        SimpleDateFormat sm = new SimpleDateFormat(strDate.length()>18?"yyyy-MM-dd HH:mm:ss":"yyyy-MM-dd");
        Date date=null;
        try{
            date=sm.parse(strDate);
        }catch(ParseException ex){
            ex.printStackTrace();
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        return actualMaximum - dayOfYear;
    }
}
