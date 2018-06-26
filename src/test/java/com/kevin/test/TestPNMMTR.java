package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年5月24日下午2:03:59
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestPNMMTR {
	public static void main(String[] args) {
		long mte=36;
		long preMte=73044;
		long postMte=283183;
		double processMTR = processMTR(mte, preMte, postMte);
		System.out.println(processMTR);
	}
	
	public static double processMTR(long MTE,long PreMTE,long PostMTE ){
		if( (PreMTE+PostMTE) != 0){
			double MTR = 10 * Math.log( MTE/(PreMTE+PostMTE));	
			return MTR;
		}else{
			double MTR = 0.0;
			return MTR;
		}
	}
}
