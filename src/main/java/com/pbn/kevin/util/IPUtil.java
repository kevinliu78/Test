package com.pbn.kevin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class IPUtil {
	
	static Logger logger =  LoggerFactory.getLogger(IPUtil.class);
	
	/**
	 * 解析IP列表，ipListStr是以逗号和中连接号连接的字符串，
	 * 类似： 192.168.1.1,192.168.4.1-192.168.4.2
	 * @param ipListStr
	 * @return
	 */
	public static List<String> parseIp(String ipListStr){
		List<String> list = new ArrayList<String>();
		if(ipListStr != null && ipListStr.length()>0){
			String[] ipArr = ipListStr.split(",");
			for(String subIp : ipArr){
				if(subIp.contains("-")){
					list.addAll(parseIpContinuous(subIp));
				}else{
					list.add(subIp);
				}
			}
		}
		return list;
	}

	public static List<String> parseIpContinuous(String ipContinuous) {
		List<String> list = new ArrayList<String>();
		String[] ipArr = ipContinuous.split("-");
		long start = toLong(ipArr[0]);
		long end = toLong(ipArr[1]);
		for(long i = start; i <= end; i++){
			list.add(toIp(i));
		}
		return list;
	}
	
	private static long toLong(String ip){
		String[] iparr = ip.split("\\.");
		String temp = "";
		for(String i : iparr){
			temp += addPrefix(Integer.toBinaryString(Integer.parseInt(i)), 8);
		}
		return Long.parseLong(temp, 2);
	}
	
	private static String toIp(long ipLong){
		String ipBinaryStr = addPrefix(Long.toBinaryString(ipLong), 32);
		String temp = "";
		for(int i = 0; i < 32; i+=8){
			temp += Integer.parseInt(ipBinaryStr.substring(i, i+8), 2) + ".";
		}
		temp = temp.substring(0, temp.length()-1);
		return temp;
	}
	
	private static String addPrefix(String str, int len){
		while(str.length()<len){
			str = "0"+str;
		}
		return str;
	}

	
	public static void main(String[] args) {
		System.out.println(parseIp("192.168.1.1,192.168.4.1-192.168.4.10"));
	}
}
