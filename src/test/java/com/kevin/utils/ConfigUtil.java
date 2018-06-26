package com.kevin.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigUtil
{
    private static final Charset CHARSET = Charset.forName("utf-8");
	private static final String CONFIG_PREFIX = "GLOBAL_CONFIG_";
    public static final long SECOND = 1000;
    public static final long MINUTE = SECOND * 60;
    public static final long HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    
    private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat sdfDateTime24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    public static Charset getCharSet()
//    {
//        return CHARSET;
//    }
	
	public static String formatDate(Date date)
	{

		if(date == null)
			return null;

		return sdfDate.format(date);
	}
	
	public static String formatDate24(Date date)
	{

		if(date == null)
			return null;

		return sdfDateTime24.format(date);
	}

	public static String formatDateTime(Date date)
	{

		if(date == null)
			return null;

		return sdfDateTime.format(date);
	}

	public static Date parseDate(String date) throws ParseException
	{

		if(date == null)
			return null;

		return sdfDate.parse(date);
	}

	public static Date parseDateTime(String date) throws ParseException
	{

		if(date == null)
			return null;

		return sdfDateTime.parse(date);
	}

	public static String urlEncode(String value)
	{
		String result = value;
		try {
			result = URLEncoder.encode(value,CHARSET.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String urlDecode(String value)
	{
		String result = value;
		try {
			result = URLDecoder.decode(value, CHARSET.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static String getCacheKey(String key)
	{
		return CONFIG_PREFIX + key;
	}


	
	
    
    /**
     * 检查Float类型是否为NULL
     * @author kevin
     * @param value
     * @return
     */
    public static float checkNull(Float value){
		return value==null? 0F : value;
	}
    
    /**
     * 检查Double类型是否为NULL
     * @author kevin
     * @param value
     * @return
     */
	public static double checkNull(Double value){
		return value==null? 0D : value;
	}
	
	/**
     * 检查String类型是否为NULL
     * @author kevin
     * @param value
     * @return
     */
	public static String checkNull(String value){
		return value==null? "" : value;
	}
	
	/**
	 * Double保留两位小数
	 * @author kevin
	 * @param o
	 * @return
	 */
	public static Double roundNumber(Double o)
	{
		if(o != null)
		{
			return roundNumber((double)o);
		}
		return 0d;
	}
	
	
	/**
	 * Float保留两位小数
	 * @author kevin
	 * @param o
	 * @return
	 */
	public static Float roundNumber(Float o)
	{
		return roundNumber((float)o);
	}
	
}


