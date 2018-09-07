package com.pbn.kevin.test;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

/**
 * @author kevin
 * @version 创建时间: 2018年7月16日上午10:02:10
 * @ClassName 类名称
 * @Description 类描述
 */
public class EnumerationTest {

    public static void main(String[] args) {

        Vector<String> v = new Vector();
        v.add("Java");
        v.add("C");

        Hashtable table = new Hashtable();
        table.put("语文", 99);
        table.put("数学", 99);
        Enumeration eVec=  v.elements();
        
        while(eVec.hasMoreElements()){
            System.out.println(eVec.nextElement());
        }
        
        Enumeration keys = table.keys();
        while(keys.hasMoreElements()) {
        		System.out.println(keys.nextElement());
        }

        Set<Map.Entry<String,Integer>> set = table.entrySet();
         Iterator<Entry<String, Integer>> iter = set.iterator();
        while(iter.hasNext()){
            Entry<String, Integer> m = iter.next();
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }
    }
}
