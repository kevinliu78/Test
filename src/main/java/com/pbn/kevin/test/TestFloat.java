package com.pbn.kevin.test;

import com.pbn.kevin.util.CacheMgr;
import com.pbn.kevin.util.ConfigUtil;

/**
 * @author kevin
 * @version 创建时间: 2018年8月23日下午2:13:40
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestFloat {
	public static void main(String[] args) {
		//test 1
//		ObjectNode json = Convert.newObject();
//		json.put("cmUpSnr", "0");
//		Float upSnr = json.get("cmUpSnr") != null ? Float.parseFloat(json.get("cmUpSnr").asText()) : 0;
//		System.out.println(upSnr.equals(0f));
		
//		CacheMgr.init();
//		//test2
		float mtr_var = 0f;
		int N = 5;
//		Float a = ConfigUtil.roundNumber((float) Math.sqrt(mtr_var / N));
		Float a = ConfigUtil.roundNumber((float) 44);
//		float b = Float.parseFloat(CacheMgr.get("G_MTR_VAR"));
		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a>b);
		
		
//		String hFreq = "55,0";
//		String[] hFreqArr = hFreq.split(",");
//		int channelIndex = 0;
//		float[] channelBean = new float[2];
//		for (int a = 0; a < hFreqArr.length; a++) {
//			String freq = hFreqArr[a];
//			if(Float.parseFloat(freq)==0)
//				continue;
//			channelBean[a] = Float.parseFloat(freq);
//			channelIndex++;
//		}
//		
//		System.out.println("channelIndex========"+channelIndex);
//		System.out.println("channelBean========"+channelBean[0]+",,,,"+channelBean[1]);
	}
}
