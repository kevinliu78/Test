package com.kevin;
/**
 * @author kevin
 * @version 创建时间: 2018年5月9日上午9:14:14
 * @ClassName 类名称
 * @Description 类描述
 */

import java.util.ArrayList;
import java.util.List;

public class TestToArray {
	 private static String[] CONTACT_POINTS;
	 
     public static void main(String[] args) {
    	 	List<String> contact_points = new ArrayList<String>();
    	 	contact_points.add("192.168.1.1");
    	 	contact_points.add("192.168.1.2");
    	 	contact_points.add("192.168.1.3");
    	 	CONTACT_POINTS = new String[contact_points.size()];
    	 	for (int i=0;i<contact_points.size();i++) {
    	 			CONTACT_POINTS[i]=contact_points.get(i);
			}
    	 	for (String string : CONTACT_POINTS) {
				System.out.println(string);
			}
	}
}
