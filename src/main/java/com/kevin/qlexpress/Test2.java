package com.kevin.qlexpress;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:26
 */
public class Test2 {
    public static void main(String[] args) {
        String content = "{\"rules\":[{\"name\":\"alarmLevel\",\"value\":\"1\",\"operator\":\"in\"}]}";
        String content1 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"av\",\"operator\":\"contains\"}]}";
        String content2 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"SNMP%wildcard%Failure\",\"operator\":\"regex\"}]}";
        String content3 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"Current Value%wildcard%RuleName%wildcard%Dashboard\",\"operator\":\"regex\"}]}";
        String content4 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"[NetappEventlog]nis.server.not.available\",\"operator\":\"regex\"}]}";
        String content5 = "{\"rules\":[{\"name\":\"alarmDesc\",\"operator\":\"regex\",\"value\":\"[NetappEventlog]nis.server.not.available\"},{\"name\":\"alarmLevel\",\"operator\":\"in\",\"value\":\"1\"}],\"upTimeCon\":[[{\"name\":\"upTime\",\"operator\":\"in\",\"preHandle\":\"getWeek\",\"value\":1},{\"name\":\"upTime\",\"operator\":\"timeRangeIn\",\"preHandle\":\"getHour\",\"value\":\"[0,1]\"}]]}";
//        String content5 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"222\",\"operator\":\"regex\"},{\"name\":\"alarmLevel\",\"operator\":\"in\",\"value\":\"1\"}],\"upTimeCon\":[[{\"name\":\"upTime\",\"operator\":\"in\",\"preHandle\":\"getWeek\",\"value\":1},{\"name\":\"upTime\",\"operator\":\"timeRangeIn\",\"preHandle\":\"getHour\",\"value\":\"[0,1]\"}]]}";

        //NetappEventlognis.server not avallable
        FilterPolicy policy = new FilterPolicy();
        policy.setId(1);
        policy.setStatus(1);
        policy.setName("test");
        policy.setDesc("test");
        policy.setPriority(0);
        policy.setContent(content5);

        Alarm alarm = new Alarm();
//        alarm.setAlarmDesc("MAPS-1003 Port 288 , Condition=ALL_E_PORTS(RX/hour>60.00), Current Value:[RX,63.70 %], RuleName=CPIC_ALL_E_PORTSRX_60, Dashboard Category=Traffic Performance.");
        alarm.setAlarmDesc("[NetappEventlog]nis.server.not.available");
        alarm.setAlarmLevel(1);
        alarm.setUpTime("2023-10-16 00:33:00");

        boolean b = policy.doMatch(alarm);
        System.out.println(b);

//        FilterPolicy policy2 = new FilterPolicy();
//        policy2.setId(2);
//        policy2.setStatus(1);
//        policy2.setName("test2");
//        policy2.setDesc("test2");
//        policy2.setPriority(0);
//        policy2.setContent(content3);
//
//        System.out.println(policy2.doMatch(alarm));

    }
}

