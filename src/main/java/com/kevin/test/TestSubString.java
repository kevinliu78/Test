package com.kevin.test;

import org.apache.commons.lang3.StringUtils;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-04-24 15:47:35
 **/
public class TestSubString {

    public static void main(String[] args) {
        String str = "2022-04-15 16:26:13 ************* Receive trap from 192.168.9.10rr";
        int pos = str.lastIndexOf(" ");
        int pos1 = str.lastIndexOf(".");
        String ip = str.substring(pos, pos1 + 2).trim();
        System.out.println(ip);


        String trapOID = "1.3.6.1.4.1.1588.2.1.1.1.0.3";

        String specific = trapOID.substring(trapOID.lastIndexOf(".") + 1);
        for (int i = 0; i < 2; i++) {
            trapOID = trapOID.substring(0, trapOID.lastIndexOf("."));
        }
        System.out.println(specific);
        System.out.println(trapOID);

        String eventOID = "1.3.6.1.4.1.35904.1.3.20.1";
        int pos11 = eventOID.lastIndexOf(".");
        int errType = Integer.parseInt(eventOID.substring(pos11 + 1));
        String oidPre = eventOID.substring(0, pos11 + 1);
        System.out.println(errType);
        System.out.println(oidPre);

        String msg1 = "DSU-10:2:1's power supply PS1 becomes normal.";
        System.out.println(msg1.contains("'s"));
        System.out.println(msg1.contains("\'s"));
        System.out.println(msg1.contains("\\'s"));
        String msg2 = "[Repeat] DSU-20:2:1's power supply PS2 is abnormal.";
        System.out.println(msg2.startsWith("[Repeat]"));
        if (msg1.toLowerCase().contains("power") && msg1.toLowerCase().contains("supply")) {
            String owner = "";
            if (msg1.startsWith("\\[Repeat\\]")) {
                owner = StringUtils.substringBetween(msg1, "\\[Repeat\\]", "\\'s");
            } else {
                owner = msg1.substring(0, msg1.indexOf("\\'s"));
            }
            System.out.println("ower=====" + owner);
        }
    }
}
