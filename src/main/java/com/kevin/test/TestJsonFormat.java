package com.kevin.test;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2023-08-16 10:02:36
 **/
public class TestJsonFormat {

    public static void main(String[] args) {
        String eventContent = "{\"alarmDesc\":\"SP_power_off,SP2 is powered off.\",\"causeLocation\":\"SP2\",\"dataSource\":\"smp\",\"deviceId\":\"0x00b34203-2bc10070-68ce2aad-3b7e91ee\",\"deviceName\":\"C23\",\"effectDesc\":\"\",\"resourceType\":104,\"resourceTypeDesc\":\"控制器\",\"serialNumber\":\"0x00b34203-2bc10070-68ce2aad-3b7e91ee\"}";
        System.out.println(formatJson(eventContent));
    }

    public static String formatJson(String jsonString) {
        // 使用正则表达式替换掉不必要的空格和缩进
        jsonString = jsonString.replaceAll("\\{", "\\{\n");
        jsonString = jsonString.replaceAll("\\}", "\n\\}");
        jsonString = jsonString.replaceAll("\\[", "\\[\n");
        jsonString = jsonString.replaceAll("\\]", "\n\\]");
//        jsonString = jsonString.replaceAll(",", ",\n");
        jsonString = jsonString.replaceAll("\":\\{", "\":\\{\n");
        jsonString = jsonString.replaceAll("\":\\[", "\":\\[\n");
        jsonString = jsonString.replaceAll("\",\"", "\",\n\"");
//        jsonString = jsonString.replaceAll("\":\"", "\":\n\"");
        return jsonString;
    }


    public static String formatJson1(String jsonString) {
        // 使用正则表达式替换掉不必要的空格和缩进
        jsonString = jsonString.replaceAll("\\{", "\\{\n");
        jsonString = jsonString.replaceAll("\\}", "\n\\}");
        jsonString = jsonString.replaceAll("\\[", "\\[\n");
        jsonString = jsonString.replaceAll("\\]", "\n\\]");
        jsonString = jsonString.replaceAll(",", ",\n");
        jsonString = jsonString.replaceAll("\":\\{", "\":\\{\n");
        jsonString = jsonString.replaceAll("\":\\[", "\":\\[\n");
        jsonString = jsonString.replaceAll("\",\"", "\",\n\"");
        jsonString = jsonString.replaceAll("\":\"", "\":\n\"");
        return jsonString;
    }
}
