package com.kevin.dbutil;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author kevin
 * @version 创建时间: Nov 27, 20189:57:11 AM
 * @ClassName 类名称
 * @Description 类描述
 */




public class ConnectionPool{
    public static void main(String[] args) throws Exception {
    		//获得连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置连接池与数据库的基本项
        dataSource.setDriverClass("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://192.168.22.205:5432/netwatch?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false");
        dataSource.setUser("lightoss");
        dataSource.setPassword("losPbn067#$");
        
        //初始化连接数目
        dataSource.setInitialPoolSize(5);
        //最小连接个数
        dataSource.setMinPoolSize(2);
        //最大连接个数
        dataSource.setMaxPoolSize(20);
        //最大空闲连接时长
//        dataSource.setMaxIdleTime(1);
        
        //获得连接
        for(int i=0;i<11;i++) {
        		if(i == 6 || i == 7 || i == 8) {
//        			TimeUnit.SECONDS.sleep(4);
        			Connection connection = dataSource.getConnection();
                System.out.println("====="+i+"========="+connection+",poolsize==="+dataSource.getNumConnections());
                connection.close();
        		}else {
        			Connection connection = dataSource.getConnection();
                System.out.println("====="+i+"========="+connection+",poolsize==="+dataSource.getNumConnections());
        		}
        }
        
        Thread.sleep(10000);
        System.out.println("=====poolsize==="+dataSource.getNumConnections());
        
	}
}