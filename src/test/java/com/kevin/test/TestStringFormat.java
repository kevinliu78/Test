package com.kevin.test;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author kevin
 * @version 创建时间: 2018年6月19日下午1:48:32
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringFormat {
	
	public static final String TOPIC_REALTIME_TO = "topic_realtime_to_%s_%s";
	
	public static void main(String[] args) {
		 String stringFormat  = "lexical error at position %s, encountered %s, expected %s ";  
		  
		 String messageFormat ="lexical error at position {0}, encountered {1}, expected {2}";  
		   
		 System.out.println(String.format(TOPIC_REALTIME_TO, 14, "GDS_GZS"));  
		   
		 System.out.println(MessageFormat.format(messageFormat, new Date(), 100, 456));  
	}
}
