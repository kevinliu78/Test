package com.kevin.test;

/**
 * @Author: LWS
 * @Date: 2020/3/30 17:19
 */
public class TestSplit {
    public static void main(String[] args) {
        String s = "resourceType,resourceId,resourceName,serialNumber,subResourceType,subResourceId,subResourceName," +
        "vendor,model,location,tags,metricGroup,metricName,metricValue,ruleId,ruleName,ruleDesc,alarmLevel,alarmFaultType," +
                "count(objectId) as oCount,unionSet(metricValueSet) as metricSet,unionSet(upTimeSet) as timeSet ";

        String[] split = s.split(",");
        System.out.println(split.length);

        String ruleDesc = "";
        String ruleDesc1 = "";

        //拼接规则描述
        String upTimeStr = "[1,19]";
        if (upTimeStr != null && !upTimeStr.isEmpty()) {
            int pos = upTimeStr.indexOf(",");
            String t1 = upTimeStr.substring(pos - 1, pos);
            String t2 = upTimeStr.substring(pos + 1, pos + 2);
            ruleDesc += "上报时间【每天" + t1 + "点到" + t2 + "点】";
        }
        int pos1 = upTimeStr.indexOf(",");
        int pos2 = upTimeStr.indexOf("[");
        int pos3 = upTimeStr.indexOf("]");
        String t1 = upTimeStr.substring(pos2 + 1, pos1);
        String t2 = upTimeStr.substring(pos1 + 1, pos3);
        ruleDesc1 += "上报时间【每周一" + t1 + "点到" + t2 + "点】";
        System.out.println(ruleDesc);
        System.out.println(ruleDesc1);

        LongTypeBean bean = new LongTypeBean();
        Long a = bean.getA() ;
        System.out.println(a+"");
    }
}
