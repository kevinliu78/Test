package com.pbn.kevin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 创建时间: Nov 12, 20183:22:23 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestJpql {
	
	public static void main(String[] args) {
		int index = 0;
		String jpql = "select d from CmMtrData d left join CableModemPreDataBean c join c.grid g on d.mac=c.MAC_ADDR where d.taskId=?0";
		index ++;
		String gridRank = "10010001,10010002,1,1,1";
		List<Object> params = new ArrayList<>();
		if(!gridRank.isEmpty()) {
			String[] split = gridRank.split(",");
			if(split.length > 0) {
				jpql += " and (";
				for (int i = 0; i < split.length; i++) {
					if(i == split.length-1) {
						jpql += "g.rank like ?" + index;
					}else {
						jpql += "g.rank like ?" + index + " or ";
					}
					index++;
					params.add(split[i]+"%");
				}
				jpql += ")";
			}
		}
		
		System.out.println(jpql);
		System.out.println(index);
		System.out.println(params.toString());
	}
	
}
