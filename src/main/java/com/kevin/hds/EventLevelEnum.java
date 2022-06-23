package com.kevin.hds;

/**
 * 告警级别类型枚举
 *
 * @Author: LWS
 * @Date: 2019/9/29 14:10
 */
public enum EventLevelEnum {

    /**
     * 事件/告警级别
     */
    NORMAL("正常", 0),
    UNKNOWN("未知", 1),
    PROMPT("提示", 2),
    WARN("警告", 3),
    WILL("次要", 4),
    IMPORTANT("重要", 5),
    EMERGENCY("紧急", 6),
    BREAKDOWN("崩溃", 7);

    private String desc;
    private int value;
    private String tooltip;

    EventLevelEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
        this.tooltip = desc;
    }

    EventLevelEnum(String desc, int value, String tooltip) {
        this.desc = desc;
        this.value = value;
        this.tooltip = tooltip;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }

    public String getTooltip() {
        return tooltip;
    }

    public static EventLevelEnum valueOf(int value) {
        for (EventLevelEnum e : EventLevelEnum.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    public static EventLevelEnum valueOfDesc(String desc) {
        for (EventLevelEnum e : EventLevelEnum.values()) {
            if (e.desc.equals(desc)) {
                return e;
            }
        }
        return null;
    }
}
