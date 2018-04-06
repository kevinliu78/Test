package com.kevin.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
*@author kevin
*@version 创建时间: 2018年1月22日下午2:56:20
*/
public class TestPostgreJDBC {
	public static void main(String[] args) {  
        try {  
            Class.forName("org.postgresql.Driver").newInstance();  
            String url = "jdbc:postgresql://192.168.35.181:5432/fbcnetwatch";  
            Connection con = DriverManager.getConnection(url, "lightoss",  
                    "losPbn067#$");  
            String sql = "insert into channel_list (channel_id,channel_list_name,annex_type,center_freq) values(?,?,?,?)";  
            PreparedStatement pstmt;  
            try {  
                pstmt = (PreparedStatement) con.prepareStatement(sql);  
                pstmt.setInt(1, 1); 
                pstmt.setString(2, "test");  
                pstmt.setString(3, "2");  
                pstmt.setString(4, "50");  
                int i = pstmt.executeUpdate();  
                pstmt.close();  
                con.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        } catch (Exception e) {  
            System.out.print("exception:" + e.getMessage());  
        }  
    }  
}
