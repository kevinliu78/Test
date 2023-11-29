package com.kevin.qlexpress.improve;

import com.kevin.qlexpress.Alarm;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:26
 */
public class Test1 {
    public static void main(String[] args) {
//        String content = "{\"rules\":[{\"name\":\"alarmLevel\",\"value\":\"1,2,3\",\"operator\":\"in\"}]}";
        String content = "{\"rules\":[{\"name\":\"alarmDesc\",\"operator\":\"regex\",\"value\":\"22222\"},{\"name\":\"alarmLevel\",\"operator\":\"in\",\"value\":\"1\"}],\"upTimeCon\":[[{\"name\":\"upTime\",\"operator\":\"in\",\"preHandle\":\"getWeek\",\"value\":1},{\"name\":\"upTime\",\"operator\":\"timeRangeIn\",\"preHandle\":\"getHour\",\"value\":\"[0,1]\"}]]}";

        FilterPolicy policy = new FilterPolicy();
        policy.setId(1);
        policy.setStatus(1);
        policy.setName("test");
        policy.setDesc("test");
        policy.setPriority(0);
        policy.setContent(content);

        Alarm alarm = new Alarm();
        alarm.setAlarmDesc("SNMP4569Failu22222re78777");
        alarm.setAlarmLevel(1);
        alarm.setUpTime("2023-10-16 00:33:00");

        boolean b = policy.doMatch(alarm);
        System.out.println(b);


    }
}

