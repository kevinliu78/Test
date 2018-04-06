package com.kevin.test;
import java.util.ArrayList;
import java.util.List;

/**
*@author kevin
*@version 创建时间: 2018年1月18日上午10:42:28
*/
public class TestListAddByIndex {
	public static void main(String[] args) {  
        List<String> list = new ArrayList<String>();  
        list.add("a");  
        list.add("b");  
        list.add("c");  
        list.add("d");  
        list.add("e");  
        System.out.println(list);  
        list.add(0, "f");  
        System.out.println(list);  
        list.add(0, "333");  
        System.out.println(list);  
    }  
}
