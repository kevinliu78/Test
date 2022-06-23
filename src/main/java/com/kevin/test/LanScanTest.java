package com.kevin.test;

import java.net.InetAddress;

public class LanScanTest {
	
	public static void main(String[] args) {
		try {
            //设置IP地址网段
            String ips = "192.168.135.";
            String ip;
            InetAddress addip;
            //遍历IP地址
            for (int i = 1; i < 255; i++) {
                ip = ips + i;
                addip = InetAddress.getByName(ip);
                //获取登录过的设备
                if (!ip.equals(addip.getHostName())) {
                    //检查设备是否在线，其中1000ms指定的是超时时间
                    boolean status = InetAddress.getByName(addip.getHostName()).isReachable(1000);     // 当返回值是true时，说明host是可用的，false则不可。
                    System.out.println("IP地址为:" + ip + "\t\t设备名称为: " + addip.getHostName() + "\t\t是否可用: " + (status ? "可用" : "不可用"));
                }
            }
        } catch (java.io.IOException uhe) {
            System.err.println("Unable to find: " + uhe.getLocalizedMessage());
        }

	}
	
}
