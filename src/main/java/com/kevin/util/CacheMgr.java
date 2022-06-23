package com.kevin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nms.util.Convert;
import com.kevin.bean.CM;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class CacheMgr {
	private static final Logger logger = LoggerFactory.getLogger(CacheMgr.class);
	protected static final String SEPARATOR = "_";
	private static final String CM_PREFIX = "PORTAL_CMINFO";
	private static final String CM_SET_KEY = "CM_SET";
	private static final String CM_MTRAVG_PREFIX = "CM_MTRAVG";
	private static final String CM_MTRAVG_KEY = "CM_MTRAVG_SET";
	private static final String CMTS_UP_CHANNEL_KEY = "CMTS_UP_CHANNEL_%s_%s";
	private static final String CMTS_DOWN_CHANNEL_KEY = "CMTS_DOWN_CHANNEL_%s_%s";
	private static final String CMTS_RPD_CHANNEL_KEY = "CMTS_RPD_CHANNEL_%s_%s";
	
	private static JedisPool jedisPool;
	private static String hostIp;
	private static int port;
	private static String password;
	private static int timeOut;
	
//	private static Set<String> cmKeySet = new HashSet<String>(100000);
	
//	private static JedisCluster jc;
	
	/**
	 * redis.serverIp="192.168.35.181"
		redis.serverPort=6379
		redis.password="Pbn@1234!@#$"
		redis.pool.maxTotal=1000000
		redis.pool.maxIdle=500000
		redis.pool.maxWait=1000
		redis.pool.testOnBorrow=true
		redis.pool.testOnReturn=true
	 */
	
	/**
	 * redis.serverIp="192.168.22.205"
		redis.serverPort=6380
		redis.password="Pbn@1234!@#$"
		redis.pool.maxTotal=1000000
		redis.pool.maxIdle=500000
		redis.pool.maxWait=1000
		redis.pool.testOnBorrow=true
		redis.pool.testOnReturn=true
	 */
	
	public static void init()
	{
//		jc = JedisClusterClient.getJedisCluster();
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(300);
		config.setMaxIdle(200);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		
		hostIp = "192.168.22.205";
		port = 6380;
		password = "Pbn@1234!@#$";
		timeOut = 3000;
		jedisPool = new JedisPool(config,hostIp,port,timeOut,password);
		logger.info("connected redis cache server,"+hostIp+":"+port);
	}
	
	private static String getCacheKey(String key) {
		if(key != null){
			String prefix = CM_PREFIX + SEPARATOR;
			if(key.startsWith(prefix)){
				return key;
			}else{
				return prefix + key;
			}
		}
		return null;
	}
	
	public static boolean expire(String cmKey) {
		if(cmKey == null)
			return false;
		
		String cacheKey = getCacheKey(cmKey);
		if(cacheKey != null) {
//			jc.del(cacheKey);
			Jedis jedis = jedisPool.getResource();
			jedis.del(cacheKey);
			jedis.close();
			return true;
		}
		
		return false;
	}
	
	public static CM getCM(String cmMac) {
		if(cmMac.length() == 12) {
			cmMac = cmMac.toLowerCase();
		}
		String cacheKey = getCacheKey(cmMac);
		if(cacheKey != null) {
			Jedis jedis = jedisPool.getResource();
			String cmJson = jedis.get(cacheKey);
//			String cmJson = jc.get(cacheKey);
			jedis.close();
			if(cmJson != null){
				return Convert.fromJson(Convert.parse(cmJson), CM.class);
			}
			return null;
		}
		return null;
	}
	
	public static Set<String> getList(String s){
		Jedis jedis = jedisPool.getResource();
		Set<String> keys = jedis.keys(CM_PREFIX+SEPARATOR+"*"+s+"*");
		return keys;
	}
	
	public static void setCM(String cmMac,CM cm) {
		String cacheKey = getCacheKey(cmMac);
		if(cacheKey != null) {
			Jedis jedis = jedisPool.getResource();
			jedis.set(cacheKey, Convert.toJson(cm));
			jedis.close();
		}
	}
	
	public static void set(String key,Object obj) {
		if(key != null) {
			Jedis jedis = jedisPool.getResource();
			jedis.set(key, Convert.toJson(obj));
			jedis.close();
		}
	}
	
	public static List<CM> getCMList(List<String> keys) {
		List<CM> cmList= new ArrayList<CM>();
		if(keys != null && keys.size() > 0){
			Jedis jedis = jedisPool.getResource();
			Pipeline pipeline = jedis.pipelined();
			List<Response<String>> responses = new ArrayList<Response<String>>();
			for(String key : keys){
				if(key.length() == 12) {
					key = key.toLowerCase();
				}
				String cacheKey = getCacheKey(key);
				Response<String> cmResponse = pipeline.get(cacheKey);
				responses.add(cmResponse);
			}
			pipeline.sync();
			jedis.close();
			for(Response<String> response : responses){
				String cmJsonStr = response.get();
//			for(String key : keys){
//				String cacheKey = getCacheKey(key);
//				String cmJsonStr = jc.get(cacheKey);
				if(cmJsonStr != null){
//					logger.info("cmJson="+cmJson);
					cmList.add(Convert.fromJson(Convert.parse(cmJsonStr), CM.class));
				}
			}
		}
		return cmList;
	}
	
	public static boolean cacheCM(CM cm) {
		if(cm == null)
			return false;
		
		String cacheKey = getCacheKey(cm.getMAC_ADDR().toLowerCase());
		String cmSetKey = getCacheKey(CM_SET_KEY);
		if(cacheKey != null) {
//			cmKeySet.add(cacheKey);
			Jedis jedis = jedisPool.getResource();
			if (cm.getCM_STATUS().equals(6)) {
				// update CM info by cacheKey
				String jsonStr = Convert.toJson(cm);
				jedis.set(cacheKey, jsonStr);
			}
			else
			{
				//非在线CM只更新缓存中的在线状态为离线
				String jsonStr = jedis.get(cacheKey);
				if(jsonStr != null){
					CM cacheCM = Convert.fromJson(jsonStr,CM.class);
					cacheCM.setCM_STATUS(cm.getCM_STATUS());
					cacheCM.setUP_SNR(cm.getUP_SNR());
					cacheCM.setUpSnrStr(cm.getUpSnrStr());
					cacheCM.setUpdateTime(cm.getUpdateTime());
					cacheCM.setCUSTOMER_NAME(cm.getCUSTOMER_NAME());
					cacheCM.setCUSTOMER_ADDRESS(cm.getCUSTOMER_ADDRESS());
					cacheCM.setCUSTOMER_PHONE(cm.getCUSTOMER_PHONE());
					cacheCM.setBusinessType(cm.getBusinessType());
					cacheCM.setGridId(cm.getGridId());
					jedis.set(cacheKey, Convert.toJson(cacheCM));
				}
				//第一次入缓存的非在线CM
				else{
					//离线cm采集第一次入库
					jedis.set(cacheKey, Convert.toJson(cm));
				}
				
//				if(cacheCM != null)
//				{
//					cacheCM.setCM_STATUS(cm.getCM_STATUS());
//					cacheCM.setUP_SNR(cm.getUP_SNR());
//					cacheCM.setUpdateTime(cm.getUpdateTime());
//					jedis.set(cacheKey, Convert.toJson(cacheCM));
//				}
//				else
//				{
//					logger.info("jsonStr==================="+jsonStr);
//					logger.warn("cache cm error!");
//				}
			}
			// add CM cache key to redis set
			jedis.sadd(cmSetKey, cacheKey);
			jedis.close();
			
//			// update CM info by cacheKey
//			String cmJson = Json.toJson(cm).toString();
//			jc.set(cacheKey,cmJson);
//			// add CM cache key to redis set
//			jc.sadd(getCacheKey(CM_SET_KEY), cacheKey);
			return true;
		}
		
		return false;
	}
	
	public static boolean cacheCMList(List<CM> list) {
		if(list == null)
			return false;
		
		Jedis jedis = jedisPool.getResource();
		Pipeline pipeline = jedis.pipelined();
		String cmSetKey = getCacheKey(CM_SET_KEY);
		for(CM cm : list){
			String cacheKey = getCacheKey(cm.getMAC_ADDR().toLowerCase());
//			cmKeySet.add(cacheKey);
			// update CM info by cacheKey
			pipeline.set(cacheKey,Convert.toJson(cm));
//			jc.set(cacheKey,Json.toJson(cm).toString());
			// add CM cache key to redis set
			pipeline.sadd(cmSetKey, cacheKey);
//			jc.sadd(getCacheKey(CM_SET_KEY), cacheKey);
			//refresh CM expire date
//			pipeline.expire(cacheKey,7200);
		}
		pipeline.sync();
		jedis.close();
		return true;
	}
	
	public static int getCachedCMCount(){
//		return cmKeySet.size();
		
		Jedis jedis = jedisPool.getResource();
		Long count = jedis.scard(getCacheKey(CM_SET_KEY));
		jedis.close();
		return count==null? 0 : count.intValue();
	}
	
	public static Set<String> getAllCMKey(){
		Jedis jedis = jedisPool.getResource();
		Set<String> allCMKey = jedis.smembers(getCacheKey(CM_SET_KEY));
		jedis.close();
		return allCMKey;
		
//		return cmKeySet;
		
//		return jc.smembers(getCacheKey(CM_SET_KEY));
	}
	
	public static void clearCMSet(){
//		cmKeySet.clear();
		
		//Cluster
		//query count of CM set
//		Long count = jc.scard(getCacheKey(CM_SET_KEY));
//		if(count!=null && count>0){
//			//remove all CM from set
//			for(long i = 0; i < count; i++){
//				jc.spop(getCacheKey(CM_SET_KEY));
//			}
//		}
		
//		//Single
		Jedis jedis = jedisPool.getResource();
		Long count = jedis.scard(getCacheKey(CM_SET_KEY));
		if(count!=null && count>0){
			Pipeline pipeline = jedis.pipelined();
			//remove all CM from set
			for(long i = 0; i < count; i++){
				pipeline.spop(getCacheKey(CM_SET_KEY));
			}
			pipeline.sync();
		}
		jedis.close();
	}
	
	public static long delKey(String key){
//		return jc.del(key);
		Jedis jedis = jedisPool.getResource();
		long count = jedis.del(key);
		jedis.close();
		return count;
	}
	
	public static String get(String key) {
		if(key != null) {
			Jedis jedis = jedisPool.getResource();
			String value = jedis.get(key);
			jedis.close();
			return value;
		}
		return null;
	}
	
	public static void set(String key,String value) {
		if(key != null) {
			Jedis jedis = jedisPool.getResource();
			jedis.set(key,value);
			jedis.close();
		}
	}
	
	private static String getCMMtrAvgKey(String key) {
		if(key != null){
			String prefix = CM_MTRAVG_PREFIX + SEPARATOR;
			if(key.startsWith(prefix)){
				return key;
			}else{
				return prefix + key;
			}
		}
		return null;
	}
	
	//获取cm 平均值
	public static Map<String, String> getCMMtrAvg(String mac) {
		try {
			String cacheKey = getCMMtrAvgKey(mac);
			if (cacheKey != null) {
				Jedis jedis = jedisPool.getResource();
				Map<String, String> map = jedis.hgetAll(cacheKey);
				jedis.close();

				if (map != null && map.size() > 0) {
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
