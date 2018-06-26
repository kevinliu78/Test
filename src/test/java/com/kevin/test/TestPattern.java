package com.kevin.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kevin
 * @version 创建时间: 2018年5月28日下午1:47:45
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestPattern {

	// Upstream-Cable0/0/2:0-RPD(a0f8.496f.f2d2)-usport0
	public static final Pattern upChannelPattern3 = Pattern.compile("^Upstream-Cable(\\d+)/(\\d+)/(\\d+):(\\d+)-RPD.*");

	// upChannel like: Cable5/0/1-upstream1
	public static final Pattern upChannelPattern = Pattern.compile("^Cable(\\d+)/(\\d+)/(\\d+)-upstream(\\d+)$");

	// Arris CMTS upstream pattern like: "cable-upstream 10/0"
	public static final Pattern upChannelPattern1 = Pattern.compile("^cable-upstream (\\d+)/(\\d+)[.](\\d+)$");

	public static void main(String[] args) {
		String ifDescr = "Cable5/0/1-upstream1";
		String ifDescr1 = "Upstream-Cable0/0/2:0-RPD(a0f8.496f.f2d2)-usport0";
		Matcher matcher = upChannelPattern.matcher(ifDescr);
		Matcher matcher1 = upChannelPattern3.matcher(ifDescr1);
		if (matcher1.find()) {
			System.out.println("111111111111111111");
			int slotIndex = Integer.parseInt(matcher1.group(1));
			int moduleIndex = Integer.parseInt(matcher1.group(2));
			int portIndex = Integer.parseInt(matcher1.group(3));
			int subPortIndex = Integer.parseInt(matcher1.group(4));
			String moduleName = "C" + slotIndex + "/" + moduleIndex + "/" + portIndex + ":" + subPortIndex;
			System.out.println(moduleName);
		}else {
			System.out.println("2222222222222222222");
		}
		System.out.println("111111111111111111");
	}
}
