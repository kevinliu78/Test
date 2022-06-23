package com.kevin.expiringmap;

import java.io.Serializable;

/**
 * 事件数据传输对象
 *
 * @Author: LWS
 * @Date: 2020/4/16 14:14
 */
public class EvEventDTO implements Serializable {

    private int eventId;

    private String upTime;

    public EvEventDTO(int eventId, String upTime) {
        this.eventId = eventId;
        this.upTime = upTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    @Override
    public String toString() {
        return "EvEventDTO{" +
                "eventId=" + eventId +
                ", upTime='" + upTime + '\'' +
                '}';
    }
}
