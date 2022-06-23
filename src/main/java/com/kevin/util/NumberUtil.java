package com.kevin.util;

import java.math.BigDecimal;

/**
 * number format tool
 * @author 
 * @date 
 */
public class NumberUtil {
	/**
	 * <pre>
	 * 	"3.1415926", 1			--> 3.1
	 * 	"3.1415926", 3			--> 3.142
	 * 	"3.1415926", 4			--> 3.1416
	 * 	"3.1415926", 6			--> 3.141593
	 * 	"1234567891234567.1415926", 3	--> 1234567891234567.142
	 * </pre>
	 */
	public static String parseNumber(String number, int precision) {
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).toPlainString();
	}

	public static String parseNumber(Number number, int precision) {
		return parseNumber(String.valueOf(number), precision);
	}

	public static double parseNumber(double number, int precision) {
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static float parseNumber(float number, int precision) {
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).floatValue();
	}
}

