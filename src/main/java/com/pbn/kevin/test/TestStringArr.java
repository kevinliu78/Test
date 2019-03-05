package com.pbn.kevin.test;
/**
 * @author kevin
 * @version 创建时间: Dec 17, 20183:17:52 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestStringArr {
	
	public static void main(String[] args) {
		String s1 = "0,NaN,55,33";
		String s2 = "55,0";
		
		System.out.println(Float.NaN < 0f);
		System.out.println(getMinMtrPosition(s1));
		System.out.println(getMinMtrPosition(s2));
	}

	/**
	 * 多频点数据，筛选出最小mtr值的上行频点
	 * @param upFreqStr
	 * @param mtrStr
	 * @return
	 */
	public static int getMinMtrPosition(String mtrStr) {
		if(mtrStr != null && !mtrStr.isEmpty()) {
			String[] mtrArr = mtrStr.split(",");
			Float min = 0f;
			int pos = 0;
			for (int i = 0; i<mtrArr.length; i++) {
				if(Float.parseFloat(mtrArr[i]) > 0f) {
					min = Float.parseFloat(mtrArr[i]);
					pos = i;
					break;
				}
			}
			System.out.println("pos==="+pos);
			System.out.println("min==="+min);
			for(int i = 0; i<mtrArr.length; i++) {
				if(!Float.isNaN(Float.parseFloat(mtrArr[i])) && !Float.isInfinite(Float.parseFloat(mtrArr[i])) && Float.parseFloat(mtrArr[i]) > 0f) {
					if(Float.parseFloat(mtrArr[i])<min) {
						min = Float.parseFloat(mtrArr[i]);
						pos = i;
					}
				}
			}
			System.out.println("======="+min);
			return pos;
		}
		return 0;
	}
	
	/**
	 * 多频点数据，根据参数upFreq返回对应的下标
	 * @param upFreq
	 * @return
	 */
	public static int getPositionByUpFreq(String upFreq,String upFreqStr) {
		if(upFreq != null && upFreqStr != null && !upFreqStr.isEmpty()) {
			String[] upFreqArr = upFreqStr.split(",");
			int pos = 0;
			for(int i = 0; i<upFreqArr.length; i++) {
				if(upFreq.equals(upFreqArr[i])) {
					pos = i;
					break;
				}
			}
			return pos;
		}
		return 0;
	}
	
}
