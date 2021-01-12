package com.pbn.kevin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kevin
 * @version 创建时间: 2020年10月19日下午1:47:45
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestPattern {

	public static final Pattern upChannelPattern = Pattern.compile("^Upstream-Cable(\\d+)/(\\d+)/(\\d+):(\\d+)-RPD.*");

	//%{IPORHOST:clientip}--\[%{HTTPDATE:timestamp}\]%{GREEDYDATA:message}
	public static void main(String[] args) {
		String ifDescr = "Upstream-Cable0/0/2:0-RPD(a0f8.496f.f2d2)-usport0";
		Matcher matcher = upChannelPattern.matcher(ifDescr);
		if (matcher.find()) {
			System.out.println("===========match success============");
			int slotIndex = Integer.parseInt(matcher.group(1));
			int moduleIndex = Integer.parseInt(matcher.group(2));
			int portIndex = Integer.parseInt(matcher.group(3));
			int subPortIndex = Integer.parseInt(matcher.group(4));
			String moduleName = "C" + slotIndex + "/" + moduleIndex + "/" + portIndex + ":" + subPortIndex;
			System.out.println(moduleName);
		}else {
			System.out.println("===========match failure============");
		}
	}
}
