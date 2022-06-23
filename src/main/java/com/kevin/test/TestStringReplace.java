package com.kevin.test;


import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: LWS
 * @Date: 2020/9/1 15:15
 */
public class TestStringReplace {
    public static void main(String[] args) {
        String desc = "MAPS-1003 Port 288%aa% , Condition=ALL_E_PORTS(RX/hour>60.00)";
//        System.out.println(desc);

        String desc2 = desc.replaceAll("%aa%", "\\$bb\\$");

//        System.out.println(desc2);

//        Integer a = null;
//        System.out.println(a == 0);

        String s1 = "10sec";
        String s2 = "10min";

//        System.out.println(s1.substring(0,s1.length()-3));
//        System.out.println(s2.substring(0,s2.length()-3));


        String s3 = "1,2,3,4,5";
        String[] split = s3.split("[,]+");
        for (String s : split) {
//            System.out.println(s);
        }

        String ipStr = "192.168.135.1-192.168.135.5";
//        System.out.println(IPUtil.parseIp(ipStr));

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);
//        System.out.println(JSONObject.toJSONString(set1));
//        System.out.println(JSONObject.toJSONString(set2));
        set1.addAll(set2);
//        System.out.println(JSONObject.toJSONString(set1));

        String src = "woshi shui ";
        String des = "shiss";
//        System.out.println(StringUtils.contains(src, des));

        String content = "%causeLocation%";
        content = StringUtils.replace(content, "%causeLocation%", null);
        System.out.println(content);
        System.out.println(content.isEmpty());
        String errorDesc = "21AA20";
        String z = errorDesc.replaceAll("[XxYy]", "%");
        System.out.println(z);
        if (z.contains("%")) {
            String substring = z.substring(0, z.indexOf("%"));
            System.out.println(substring);
        }

        String aa = "1,2,3,4";
        aa = StringUtils.replace(aa,"3","");
        aa = StringUtils.replace(aa,",,",",");
    }

}
