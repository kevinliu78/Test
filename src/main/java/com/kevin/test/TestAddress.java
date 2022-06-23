package com.kevin.test;

import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;

/**
 * @Author: LWS
 * @Date: 2020/12/30 14:27
 */
public class TestAddress {
    public static void main(String[] args) {
        try {
            byte[] address = InetAddress.getByName("146.240.125.201").getAddress();
            InetAddress byAddress = InetAddress.getByAddress(address);
            String addressStr = byAddress.toString();
            System.out.println(addressStr.substring(addressStr.lastIndexOf("/") + 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String diskIndex = StringUtils.substringAfterLast("21AA19", "21AA");
        System.out.println("disk index " + diskIndex);

        StringBuffer s1 = new StringBuffer("abc");//定义一个baiStringBuffer
        s1.insert(1,"56");//追加
        String s3=s1.toString();//将StringBuffer转化du为String
        String s2="kk";
        System.out.println(s2+s3);

        StringBuilder sb = new StringBuilder("3D");
        sb.insert(1,"-");
        System.out.println("CL"+sb.toString());
    }
}
