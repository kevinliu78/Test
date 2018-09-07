package com.pbn.kevin.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author kevin
 * @version 创建时间: 2018年9月7日下午2:24:52
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestSelect {
	public static void main(String[] args) throws IOException {
//		DBUtils dbUtils = new DBUtils();
		Connection con = PostgreMgr.getConn();
		String sql = "select max(task_id) from cm_mtr_report";
		PreparedStatement pstmt;
		int newid = 0;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			java.sql.ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				newid = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(newid);
	}
}
