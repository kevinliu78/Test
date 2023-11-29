package com.kevin.test;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.kevin.util.TagsConvertUtils;

import java.util.Set;

/**
 * @author kevin
 * @version 创建时间: 2018年9月13日上午10:57:26
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringFomat {
    public static void main(String[] args) {
        int emsCode = 14;
        String cityCode = "GDS_GZS_01";
        String topic1 = String.format("TOPIC_CMTS_CHASSIS_%s_%s", emsCode, cityCode);
        System.out.println(topic1);
//        String s1 = test1("ha121", "ha", "彩票结算系统");
//        String s1 = test1("ha121", "", "彩票结算系统");
        String s1 = test1("ha121", "lwstttttt", null);
        System.out.println(s1);

        String tags = "{\"区域\":[\"生产区\"],\"用途\":[\"生产\"],\"服务\":[\"FS服务\",\"对象服务\",\"块服务\"],\"池类型\":[\"中端\"],\"system\":[\"测试系统\"],\"appsystem\":[\"测试子系统\"]}";
//        String tagsValue = TagsConvertUtils.queryTasValueByTagsKey(tags,"system");
        JSONObject jsonObject = JSONObject.parseObject(tags);
        String system = getTagValueByJson(jsonObject, "system");
        System.out.println(system);

//        java保留小数--四舍五入--想保留几位就几位
//        String.format("%.nf",d);----表示保留N位！！！format("%.nf",double)
        double d = 5.3333333;
        String str1 = String.format("%.2f", d);
        String str2 = String.format("%.3f", d);
        System.out.println(str1);
        System.out.println(str2);
    }

    public static String getTagValueByJson(JSONObject tags, String key) {
        String result = "";
        if (tags == null || tags.isEmpty()) {
            return null;
        }
        Set<String> keys = tags.keySet();
        if (!keys.contains(key)) {
            return null;
        }
        if (tags != null) {
            String valueStr = tags.getString(key);
            if (valueStr.contains("]")) {
                JSONArray str = tags.getJSONArray(key);
                for (int i = 0; i < str.size(); i++) {
                    String value = str.getString(i);
                    result += value + ",";
                }
                if (result.charAt(result.length() - 1) == ',') {
                    result = result.substring(0, result.length() - 1);
                }
            } else {
                result = valueStr;
            }
        }
        return result;
    }


    private static String test1(String portAlias, String nodeResourceName, String appInfo) {
        String effectFormat1 = "端口别名:%s,对端设备:[%s],应用系统:%s";
        String effectFormat2 = "端口别名:%s,对端设备:[%s]";
        String effectDesc = "端口别名: " + portAlias;
        if (nodeResourceName != null && !nodeResourceName.isEmpty()) {
            effectDesc += ",对端设备: [" + nodeResourceName + "]";
        }
        if (appInfo != null && !appInfo.isEmpty()) {
            effectDesc += ",应用系统: " + appInfo;
        }
        return effectDesc;
    }
}
