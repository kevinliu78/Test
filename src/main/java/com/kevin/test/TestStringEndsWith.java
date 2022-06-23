package com.kevin.test;

/**
 * @Author: LWS
 * @Date: 2021/1/19 11:27
 */
public class TestStringEndsWith {

    public static void main(String[] args) {
        String fileName1 = "filterRule.json";
        String fileName2 = "filterRule.b64";

        System.out.println(fileName1.endsWith("b64"));
        System.out.println(fileName2.endsWith("b64"));

        String eventTrack = "解析,未格式化[设备名称: 145.0.223.13]存储[ID: 707793404741867584],发送事件,接收事件," +
                "未过滤,更新事件表,发送告警规则,[规则名称: 所有关键词规则0],未匹配关键词规则,发送未知类型规则,匹配规则[规则名称: 未知类型]";
        String eventTrack2 = "解析,未格式化[设备名称: 145.0.207.16]存储[ID: 707609837839636545],发送事件,接收事件," +
                "未过滤,更新事件表,发送告警规则,[规则名称: 所有关键词规则0],未匹配关键词规则,发送未识别类型规则,匹配规则[规则名称: 未识别类型]";

        System.out.println(eventTrack.endsWith("匹配规则[规则名称: 未知类型]"));
        System.out.println(eventTrack2.endsWith("匹配规则[规则名称: 未识别类型]"));
    }
}
