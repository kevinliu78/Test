package com.pbn.kevin.dbutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@author kevin
*@version 创建时间: 2018年1月23日上午9:23:57
*/
public class PostgreMgr {

	private static final Logger logger = LoggerFactory.getLogger(PostgreMgr.class);
    
	public static Connection getConn() throws IOException {  
		FileInputStream fis = null;
	    
	    Properties env = new Properties();
		fis = new FileInputStream("conf/dbconfig.properties");
        //加载属性文件中的数据库配置信息
        //以=左边作为key值，右边作为value值
        env.load(fis); 
        
        //1. 加载驱动类
        
        String driver = env.getProperty("jdbc.driver");
        String url = env.getProperty("jdbc.url");
        String username = env.getProperty("jdbc.username");
        String password = env.getProperty("jdbc.pwd");
        Connection conn = null;  
        try {  
            Class.forName(driver); // classLoader,加载对应驱动  
            conn = (Connection) DriverManager.getConnection(url, username, password);  
        } catch (ClassNotFoundException e) {  
            logger.error("postgresql connect classnotfound error="+e.getMessage());
        } catch (SQLException e) {  
        	logger.error("postgresql connect sqlexception error="+e.getMessage());
        }  
        return conn;  
    }  
}
