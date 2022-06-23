package com.kevin.fbc.fft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 创建时间: 2018年4月2日下午3:09:46
 * @ClassName 类名称
 * @Description 类描述
 */
public class CalculateFFTDemo {
	
	public static List CalculateFFT(Long[] iDataList, Long[] qDataList) {
		try {
			int dataSize = iDataList.length;
			Complex[] sp = new Complex[dataSize];
			int fft_size = dataSize/2;
			for(int i=0;i<dataSize;i++) {
//				System.out.println(iDataList[i]+"============"+qDataList[i]);
				sp[i] = new Complex(iDataList[i], qDataList[i]);
			}
//			xs = sp[:fft_size] * signal.hann(fft_size, sym=0)
			double[] xf = new double[dataSize];
			Complex[] FFTOut = FFT.fft(sp);
			List<Double> arr = new ArrayList<Double>();
			for (int i=0;i<dataSize;i++) {
				xf[i] = FFTOut[i].divideInteger(fft_size).abs();
				arr.add(20*(Math.log10(xf[i])));
			}
			int temp = dataSize/4;
			List<Double> result = new ArrayList<Double>();
			result.addAll(arr.subList(3*temp, dataSize));
			result.addAll(arr.subList(0, temp));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String doubleToSTR(double[] D) {
		if(D==null)
			return "";
		String str = "";
		for (double e : D) {
			str+=e+",";
		}
		return str;
	}
}
