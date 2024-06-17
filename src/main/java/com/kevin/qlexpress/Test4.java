package com.kevin.qlexpress;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:26
 */
public class Test4 {
    public static void main(String[] args) {
//        String content = "{\"rules\":[{\"name\":\"vendor\",\"operator\":\"regex\",\"value\":\"h3c\"}],\"matchType\":0}";
        String content = "{\"rules\":[{\"name\":\"vendor\",\"operator\":\"regexInsensitive\",\"value\":\"h3c\"}],\"matchType\":0}";

        //NetappEventlognis.server not avallable
        FilterPolicy policy = new FilterPolicy();
        policy.setId(1);
        policy.setStatus(1);
        policy.setName("test");
        policy.setDesc("test");
        policy.setPriority(0);
        policy.setContent(content);

        Alarm alarm = new Alarm();
        alarm.setAlarmDesc("[NetappEventlog]nis.server.not.available");
        alarm.setAlarmLevel(1);
        alarm.setUpTime("2024-02-04 10:33:00");
        alarm.setVendor("H3C");

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

