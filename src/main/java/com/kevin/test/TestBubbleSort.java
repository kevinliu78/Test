package com.kevin.test;

import java.util.Arrays;

/**
 * @author kevin
 * @version 创建时间: Feb 22, 20191:51:19 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestBubbleSort {
	public static void main(String[] args) {
		int[] arr = {5,3,5,2,8};
		int temp;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]<arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
