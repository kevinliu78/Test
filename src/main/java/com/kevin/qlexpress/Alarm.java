package com.kevin.qlexpress;

/**
 * @Author: LWS
 * @Date: 2020/9/14 18:38
 */
public class Alarm {
    private Integer alarmLevel;
    private Integer alarmFaultType;
    private String alarmDesc;
    private String upTime;
    private Integer resourceType;
    private Long resourceId;
    private String vendor;

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

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public Integer getAlarmFaultType() {
        return alarmFaultType;
    }

    public void setAlarmFaultType(Integer alarmFaultType) {
        this.alarmFaultType = alarmFaultType;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
