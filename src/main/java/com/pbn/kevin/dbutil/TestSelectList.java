package com.pbn.kevin.dbutil;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nms.util.Convert;
import com.pbn.kevin.bean.CM;
import com.pbn.kevin.util.CacheMgr;

/**
 * @author kevin
 * @version 创建时间: 2018年9月7日下午2:24:52
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestSelectList {
	public static void main(String[] args) throws Exception {
		long t1 = System.currentTimeMillis();
		selectOdnAll();
		System.out.printf("run time :%s",(System.currentTimeMillis()-t1));
	}
	
	public static void selectOdnCmList() throws Exception {
		Connection con = PostgreMgr.getConn();
		CacheMgr.init();
		String sql = "select lower(o.cm_mac) as mac from odn_cm_relation o where lower(o.odn_code)=?  and o.headend_name like ? ";
		PreparedStatement pstmt = null;
		String odnCode = "010401090200046";
		String headendName = "石牌";
		List<String> macList = new ArrayList<String>();
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, odnCode);
			pstmt.setString(2, "%"+headendName+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				macList.add(rs.getString("mac"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		String upFreqStr = "";
		Set<String> upFreqSet = new HashSet<String>();
		List<CM> cmList = CacheMgr.getCMList(macList);
		if(macList != null && macList.size()>0) {
			for (CM cm : cmList) {
				if(cm.getUpFreqStr() != null) {
					String[] split = cm.getUpFreqStr().split(",");
					for (String s : split) {
						upFreqSet.add(s);
					}
				}
			}
		}
		List<String> list = new ArrayList<String>(upFreqSet);
		Collections.sort(list,(o1,o2) -> {return o1.compareTo(o2);});
		for (int i=0;i<list.size();i++) {
			if(i == list.size()-1) {
				upFreqStr += list.get(i)+"";
			}else {
				upFreqStr += list.get(i)+",";
			}
		}
		System.out.println(upFreqStr);
//		System.out.println(Convert.toJson(macList));
//		System.out.println(macList.size());
	}
	
	public static void selectOdnAll() throws Exception {
		String sql = "select d.odn_code odncode,t.headendname headendname FROM device_link d left join "
				+ "(select c.hostip cmtsip,h.name headendname from cmts_chassis c left join headend h on c.headend_id=h.id) t on d.cmts_ip=t.cmtsip";
		
		Connection con = PostgreMgr.getConn();
		PreparedStatement pstmt = null;
		List<ODNData> list = new ArrayList<ODNData>();
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ODNData o = new ODNData();
				o.odnCode = rs.getString("odncode");
				o.headendName = rs.getString("headendname");
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		System.out.println(list.size());
		System.out.println(Convert.toJson(list));
	}
	
	public static class ODNData implements Serializable {
		//光站编号
		public String odnCode;
		//前端名称
		public String headendName;
		//光站下所有频点信息
		public String up_freq_str = "";
//		public int ch_size = 0;
//		public ODNCHannelData[] ch_arr;
		public List<CM> cmlist;
	}
	
	
}




















