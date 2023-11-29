package com.kevin.test;

import com.kevin.util.DateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2022-10-10 16:41:24
 **/
public class TestPing {

    public static void main(String[] args) {
        try {
            long t1 = System.currentTimeMillis();
            boolean ping = ping("192.168.136.215");
            System.out.println("ping==" + ping + ",cost time=" + (System.currentTimeMillis() - t1));
//            String mqAddress = "192.168.135.212:5671,192.168.135.213:5671";
            String mqAddress = "192.168.135.212,192.168.135.213:5671";
            String[] ipList = mqAddress.split(",");
            for (String ip : ipList) {
                if (ip.contains(":")) {
                    ip = ip.substring(0, ip.indexOf(":"));
                }
                String url = "http://" + ip + ":15672/api/queues";
                System.out.println(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String time = "2022-10-14 18:05:00";
        Date date = DateFormatUtil.parseDateTime24(time);
        System.out.println(date.compareTo(new Date()));
    }

    public static boolean ping(String ipAddress) throws Exception {
        int timeOut = 3000;
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
        return status;
    }

    public static boolean ping(String ipAddress, int pingTimes, int timeOut) {
        BufferedReader in = null;
        Runtime r = Runtime.getRuntime();
        // 将要执行的ping命令,此命令是windows格式的命令
        String pingCommand = "ping " + ipAddress + " -n " + pingTimes + " -w " + timeOut;
        // Linux命令如下
        // String pingCommand = "ping" -c " + pingTimes + " -w " + timeOut + ipAddress;
        try {
            // 执行命令并获取输出
            Process p = r.exec(pingCommand);
            if (p == null) {
                return false;
            }
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int connectedCount = 0;
            String line;
            // 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
            while ((line = in.readLine()) != null) {
                connectedCount += getCheckResult(line);
            }
            // 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
            return connectedCount == pingTimes;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
    private static int getCheckResult(String line) {  // System.out.println("控制台输出的结果为:"+line);
        Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            return 1;
        }
        return 0;
    }


}
