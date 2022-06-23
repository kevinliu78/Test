package com.kevin.qlexpress;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:26
 */
public class Test {
    public static void main(String[] args) {
        String content = "{\"rules\":[{\"name\":\"alarmLevel\",\"value\":\"1\",\"operator\":\"in\"}]}";
        String content1 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"av\",\"operator\":\"contains\"}]}";
        String content2 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"SNMP%wildcard%Failure\",\"operator\":\"regex\"}]}";
        String content3 = "{\"rules\":[{\"name\":\"alarmDesc\",\"value\":\"Current Value%wildcard%RuleName%wildcard%Dashboard\",\"operator\":\"regex\"}]}";
        FilterPolicy policy = new FilterPolicy();
        policy.setId(1);
        policy.setStatus(1);
        policy.setName("test");
        policy.setDesc("test");
        policy.setPriority(0);
        policy.setContent(content);

        Alarm alarm = new Alarm();
//        alarm.setAlarmDesc("MAPS-1003 Port 288 , Condition=ALL_E_PORTS(RX/hour>60.00), Current Value:[RX,63.70 %], RuleName=CPIC_ALL_E_PORTSRX_60, Dashboard Category=Traffic Performance.");
        alarm.setAlarmDesc("SNMP4569Failure78777");
        alarm.setAlarmLevel(1);

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

