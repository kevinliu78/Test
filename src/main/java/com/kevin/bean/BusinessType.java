package com.kevin.bean;

/**
 *@author kevin
 *@version 创建时间: 2017年9月26日上午10:33:38
 */
public enum BusinessType {
	NONE,INTERACT,BROADBAND,HYBRID;
	
	public static String i18n(BusinessType code)
	{
//		try
//		{
//			if(code == INTERACT) {
//				return ConfigUtil.getMessage("enum.interact");
//			}else if(code == BROADBAND) {
//				return ConfigUtil.getMessage("enum.broadband");
//			}else if(code == HYBRID) {
//				return ConfigUtil.getMessage("enum.hybrid");
//			}else {
//				return ConfigUtil.getMessage("enum.none");
//			}
//		}
//		catch(NumberFormatException e)
//		{
//			return ConfigUtil.getMessage("enum.none");
//		}
		return null;
	}
}
