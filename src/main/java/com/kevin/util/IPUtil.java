package com.kevin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class IPUtil {

    static Logger logger = LoggerFactory.getLogger(IPUtil.class);

    /**
     * 解析IP列表，ipListStr是以逗号和中连接号连接的字符串，
     * 类似： 控制器IP格式要求
     * 对于IP网段用0/24代替,例如:
     * 192.168.124.0/24,代表192.168.124.0,192.168.124.1,…,192.168.124.255;
     * 对于部分网段使用XX-XX,例如:
     * 192.168.124.1-10,代表192.168.124.1,192.168.124.2,…,192.168.124.10;
     *
     * @param ipListStr
     * @return
     */
    public static Set<String> parseIp(String ipListStr) {
        Set<String> set = new HashSet<>();
        if (ipListStr != null && ipListStr.length() > 0) {
            String[] ipArr = ipListStr.split(",");
            for (String subIp : ipArr) {
                if (subIp.contains("-")) {
                    String[] split1 = subIp.split("\\.");
                    String[] split2 = split1[3].split("-");
                    String s1 = split1[0] + "." + split1[1] + "." + split1[2] + ".";
                    subIp = s1 + split2[0] + "-" + s1 + split2[1];
                    set.addAll(parseIpContinuous(subIp));
                } else if (subIp.contains("0/24")) {
                    String[] split1 = subIp.split("\\.");
                    String s1 = split1[0] + "." + split1[1] + "." + split1[2] + ".";
                    subIp = s1 + "0-" + s1 + "255";
                    set.addAll(parseIpContinuous(subIp));
                } else {
                    set.add(subIp);
                }
            }
        }
        return set;
    }

    /**
     * 解析IP列表，ipListStr是中连接号连接的字符串，
     * 类似： 192.168.4.1-192.168.4.2
     *
     * @param ipContinuous
     * @return
     */
    public static Set<String> parseIpContinuous(String ipContinuous) {
        Set<String> set = new HashSet<>();
        String[] ipArr = ipContinuous.split("-");
        long start = toLong(ipArr[0]);
        long end = toLong(ipArr[1]);
        for (long i = start; i <= end; i++) {
            set.add(toIp(i));
        }
        return set;
    }

    private static long toLong(String ip) {
        String[] iparr = ip.split("\\.");
        String temp = "";
        for (String i : iparr) {
            temp += addPrefix(Integer.toBinaryString(Integer.parseInt(i)), 8);
        }
        return Long.parseLong(temp, 2);
    }

    private static String toIp(long ipLong) {
        String ipBinaryStr = addPrefix(Long.toBinaryString(ipLong), 32);
        String temp = "";
        for (int i = 0; i < 32; i += 8) {
            temp += Integer.parseInt(ipBinaryStr.substring(i, i + 8), 2) + ".";
        }
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }

    private static String addPrefix(String str, int len) {
        while (str.length() < len) {
            str = "0" + str;
        }
        return str;
    }


    public static void main(String[] args) {
        Set<String> ipList = parseIp("1");
Set<String> result = new HashSet<>();
result.add("aa");
result.addAll(ipList);
        System.out.println(result);
        System.out.println(result.size());
    }
}
