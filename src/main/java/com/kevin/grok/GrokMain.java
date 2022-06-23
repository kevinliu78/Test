package com.kevin.grok;

import java.util.Map;

/**
 * @Author: LWS
 * @Date: 2020/10/20 16:18
 */
public class GrokMain {
    //public static final String log = "2020-03-30 10:20:30.405 INFO [SERVICENAME,vgctd46vo7978fcrt545d979yg,gyub7868ghjvg545,false] [oi-13-thread-1] classname [monitorInfo]:173 - #@monitor#@dataquery#@coxquery#@{\"sysname\":\"coxquery\",\"monitorTarget\":\"CHDL2030\",\"responseTime\":\"20\",\"code\":\"200\",\"ip\":\"10.2.57.100\"}";
    public static final String log = "2020-03-30 10:20:30.405 INFO [SERVICENAME,vgctd46vo7978fcrt545d979yg,gyub7868ghjvg545,false] [oi-13-thread-1] classname [monitorInfo]:173 - #@monitor#@dataquery#@coxquery#@{\"sysname\":\"coxquery\",\"subjson\":{\"subName\":\"2345\"},\"monitorTarget\":\"CHDL2030\",\"responseTime\":\"20\",\"code\":\"200\",\"ip\":\"10.2.57.100\"}";
    public static void main(String[] args){
        String pattern = "^%{LOGDATE:recordTime}.+?,%{DATA:TRACEID},.+?%{LOGJSON:JSON}$";
        Map<String, Object> map = GrokUtils.toMap(pattern, log);
        System.out.println(map.toString());
    }

}
