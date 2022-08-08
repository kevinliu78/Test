package com.kevin.ip;

import com.alibaba.fastjson2.JSONObject;
import com.kevin.util.IPUtil;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-28 15:48:46
 **/
public class Test {

    public static void main(String[] args) {
        try {
            String myIpAddress = InetAddress.getLocalHost().getHostAddress();
            List<String> ipList = IPUtil.getLocalIpList();
            for (String ip : ipList) {
                String[] split = ip.split("\\.");
                System.out.println(split[2]+"."+split[3]);
            }
            System.out.println(JSONObject.toJSONString(ipList));

            Map<String,String> testMap = new HashMap<>();
            Map<String,String> testMap2 = new HashMap<>();
            testMap.put("1","11");
            testMap.put("2","22");
            testMap.put("3","33");
            testMap2.put("1","11_new");
            testMap2.put("2","22_new");
            testMap2.put("3","33_new");
            System.out.println(JSONObject.toJSONString(testMap));
            testMap = testMap2;
            System.out.println(JSONObject.toJSONString(testMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
