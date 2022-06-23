package com.kevin.qlexpress.improve;

import com.kevin.qlexpress.Alarm;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:26
 */
public class Test {
    public static void main(String[] args) {
//        String content = "{\"rules\":[{\"name\":\"alarmLevel\",\"value\":\"1,2,3\",\"operator\":\"in\"}]}";
        String content = "{\"rules\":[{\"name\":\"alarmLevel\",\"value\":\"1,2,3\",\"operator\":\"in\"}],\"upTimeCon\":[[{\"name\":\"upTime\",\"preHandle\":\"getWeek\",\"value\":3,\"operator\":\"in\"},{\"name\":\"upTime\",\"preHandle\":\"getHour\",\"value\":\"[1,3]\",\"operator\":\"timeRangeIn\"}],[{\"name\":\"upTime\",\"preHandle\":\"getHour\",\"value\":\"[5,7]\",\"operator\":\"timeRangeIn\"}]]}";

        FilterPolicy policy = new FilterPolicy();
        policy.setId(1);
        policy.setStatus(1);
        policy.setName("test");
        policy.setDesc("test");
        policy.setPriority(0);
        policy.setContent(content);

        Alarm alarm = new Alarm();
        alarm.setAlarmDesc("SNMP4569Failure78777");
        alarm.setAlarmLevel(1);
        alarm.setUpTime("2022-02-23 02:33:00");

        boolean b = policy.doMatch(alarm);
        System.out.println(b);

        String[] columns = {"ruleName", "priority", "featureCode", "eventDesc", "upTimeConDesc"};
        for (String column : columns){
            switch (column){
                case "ruleName":
                    System.out.println("ruleName111");
                    break;
                case "priority":
                    System.out.println("priority111");
                    break;
                case "featureCode":
                    System.out.println("featureCode111");
                    break;
                case "eventDesc":
                    System.out.println("eventDesc111");
                    break;
                case "eventLevel":
                    System.out.println("eventLevel111");
                    break;
                case "upTimeConDesc":
                    System.out.println("upTimeConDesc111");
                    break;
            }
        }


    }
}

