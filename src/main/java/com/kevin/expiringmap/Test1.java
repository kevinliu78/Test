package com.kevin.expiringmap;

import com.kevin.util.ConfigUtil;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2021-07-21 17:54:38
 **/
public class Test1 {

    private static ExpiringMap<String, List<EvEventDTO>> map = ExpiringMap.builder().expiration(5000, TimeUnit.MILLISECONDS)
            .expirationPolicy(ExpirationPolicy.CREATED).build();

    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test1() throws Exception {
        String upTime1 = ConfigUtil.formatDate24(new Date());
        saveEvent(1, upTime1);
        saveEvent(2, upTime1);
//        System.out.println("key=" + upTime1 + ",value=" + map.get(upTime1));
        Thread.sleep(4000);
//        System.out.println("访问map：key=" + upTime1 + ",value=" + map.get(upTime1));
        String upTime2 = ConfigUtil.formatDate24(new Date());
        saveEvent(3, upTime2);
        saveEvent(4, upTime2);
        System.out.println("========================1================================");
        queryMap();
        Thread.sleep(1001);
        System.out.println("========================2================================");
        queryMap();
//        System.out.println("key=" + upTime1 + ",value=" + map.get(upTime1));
//        System.out.println("key=" + upTime2 + ",value=" + map.get(upTime2));
        Thread.sleep(4005);
        System.out.println("========================3================================");
        queryMap();
//        System.out.println("访问map：key1=" + upTime2 + ",value=" + map.get(upTime2));
    }

    private static void saveEvent(int eventId, String upTime) {
        EvEventDTO event = new EvEventDTO(eventId, upTime);
        List<EvEventDTO> eventList = map.get(event.getUpTime());
        if (eventList == null) {
            eventList = new ArrayList<>();
        }
        eventList.add(event);
        map.put(event.getUpTime(), eventList);
    }

    private static void queryMap() {
        for (Map.Entry<String, List<EvEventDTO>> entry : map.entrySet()) {
            System.out.println("uptime=========" + entry.getKey());
            List<EvEventDTO> eventList = entry.getValue();
            if (eventList != null && eventList.size() > 0) {
                for (EvEventDTO event : eventList) {
                    System.out.println(event);
                }
            }
        }
    }

}
