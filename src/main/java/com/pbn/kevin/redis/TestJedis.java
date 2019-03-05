package com.pbn.kevin.redis;

import com.nms.util.Convert;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author kevin
 * @version 创建时间: Nov 7, 201810:15:09 AM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestJedis {
	private static JedisPool jedisPool;
	private static String hostIp;
	private static int port;
	private static String password;
	private static int timeOut;
	
	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(300);
		config.setMaxIdle(200);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		hostIp = "localhost";
		port = 6379;
		password = "Pbn@1234!@#$";
		timeOut = 3000;
		jedisPool = new JedisPool(config,hostIp,port,timeOut);
		Jedis jedis = jedisPool.getResource();
		if(jedis.exists("test")) {
			jedis.del("test");
			jedis.srem("testSet", "test");
		}
		// NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
		jedis.set("test", "3", "NX", "EX", 60);
//		jedis.sadd("testSet", "test");
	}
}
