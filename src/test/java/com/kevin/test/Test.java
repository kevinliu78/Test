package com.kevin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 创建时间: 2018年3月6日下午4:33:40
 * @ClassName 类名称
 * @Description 类描述
 */
public class Test   
{    
    public static void main(String[] args)   
    {    
    		List<Integer> list1 = new ArrayList<Integer>();
    		List<Integer> list2 = new ArrayList<Integer>();
    		for(int i=0;i<100;i++) {
    			list1.add((int)(Math.random()*1000));
    		}
    		for(int i=0;i<100;i++) {
    			list2.add((int)(Math.random()*1000));
    		}
    		List<Integer> list3 = new ArrayList<Integer>();
    		for (Integer integer : list2) {
				list3.add(integer);
			}
    		System.out.println(list3.size());
    		for(int j=0;j<list2.size();j++) {
    			if(list1.contains(list2.get(j))) {
    				list2.remove(j);
    			}
    		}
    		
    		System.out.println(list2.size());
    		System.out.println(list3.size());
    }    
}    
    
