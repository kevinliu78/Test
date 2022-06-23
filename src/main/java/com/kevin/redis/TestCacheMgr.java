package com.kevin.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.kevin.util.CacheMgr;

/**
 * @author kevin
 * @version 创建时间: Oct 22, 201812:37:32 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestCacheMgr {
	public static void main(String[] args) {
		CacheMgr.init();
//		Set<String> list = CacheMgr.getList("");
//		for (String s : list) {
//			System.out.println(s.substring(("PORTAL_CMINFO_").length()));
//		}
		Set<String> cmKeys = CacheMgr.getAllCMKey();
		List<String> result = new ArrayList<>();
		for (String cmKey : cmKeys) {
			if(cmKey.contains("401dc")) {
//				result.add(s.substring((CM_PREFIX + SEPARATOR).length()));
				result.add(cmKey);
			}
		}
		System.out.println(result.toString());
	}
	
	
	
}
