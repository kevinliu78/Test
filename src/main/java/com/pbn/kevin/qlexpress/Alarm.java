package com.pbn.kevin.qlexpress;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:38
 */
public class Alarm {
    private Integer alarmLevel;
    private String alarmDesc;

    public Alarm() {
    }

    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmDesc() {
        return alarmDesc;
    }

    public void setAlarmDesc(String alarmDesc) {
        this.alarmDesc = alarmDesc;
    }
}
