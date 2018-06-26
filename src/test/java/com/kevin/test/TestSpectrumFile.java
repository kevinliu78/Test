package com.kevin.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nms.util.Convert;

/**
 * @author kevin
 * @version 创建时间: 2018年5月24日下午3:56:19
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestSpectrumFile {
	
	private static final Logger logger = LoggerFactory.getLogger(TestSpectrumFile.class);
	
	public static Map<String, ArrayNode> map = new ConcurrentHashMap<String,ArrayNode>();
	public static void main(String[] args) {
		readDataByTime();
	}
	/**
	 * 根据开始结束时间查询所有频点数据
	 * @param nmscfg
	 * @param neid
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static ArrayNode readDataByTime(){
		ArrayNode result = Convert.newObject().arrayNode();
		try {
			readDataFromFile("192.168.168.168", 1, 1, "192.168.168.168_1_1_2018-05-24_10.txt", 1527127200000l, 1527138000000l);
//			readDataFromFile("192.168.168.168", 1, 1, "192.168.168.168_1_1_2018-05-22_0.txt", 1526918400045l, 1526921040018l);
			long t1 = System.currentTimeMillis();
			Iterator<String> dataIter = map.keySet().iterator();
			logger.info("map size========"+map.size());
			while (dataIter.hasNext()) {
				ObjectNode node = Convert.newObject();
				String key = (String) dataIter.next();
				ArrayNode data = (ArrayNode)map.get(key);
				node.put("time", key);
				node.set("list", data);
				result.add(node);
			}
			long t2 = System.currentTimeMillis();
			logger.info("t2-t1=="+(t2-t1));
			
			map.clear();
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
//		logger.error("lishipinpushuju----------------"+Convert.toJson(result));
		return result;
		
	}
	/**
	 * 根据开始结束时间，获取文件中相关数据信息
	 * @param cfbcHistoryInfo
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static void readDataFromFile(String hostIp, int slot, int port,String fileName, long startTime, long endTime){
		
		String strAgentHome = "/Users/kevin/Development/ANGA展会环境/history";
//		logger.info("strAgentHome=="+strAgentHome);
		String dirpath = strAgentHome + hostIp + "_" + slot + "_" + port;
		String filepath = strAgentHome+"/"+fileName;
//		logger.info("dirpath=="+dirpath);
//		logger.info("filepath=="+filepath);
		String line = "";
		long start = System.currentTimeMillis();
		File file = new File(filepath);   
		BufferedInputStream fis = null;
		BufferedReader reader = null;
		try {
			if(file.exists()){
				fis = new BufferedInputStream(new FileInputStream(file));
				reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);
				while((line = reader.readLine()) != null){
					String time = "";
					String data = "";
					StringTokenizer sTokenizer = new StringTokenizer(line, "|");
					if(sTokenizer.hasMoreTokens()){
						time = sTokenizer.nextToken();
						if(Long.parseLong(time)>=startTime
								&&Long.parseLong(time)<=endTime){
							data = sTokenizer.nextToken();
							if(map.containsKey(time)){
								continue;
							}
							if(data.equals("[]")){
								logger.info("filter data is []");
								continue;
							}
							ArrayNode arr = (ArrayNode)Convert.parse(data);
//							logger.info("1111111111111===============11111111111111======找到一条历史数据");
							map.put(time, arr);
						}
						
						if(Long.parseLong(time)>endTime)break;
					}
				}
				
				reader.close();
				fis.close();
			}
		} catch (FileNotFoundException e) {
			logger.error(e.toString(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.toString(), e);
		}  catch (NumberFormatException | IOException e) {
			logger.error(e.toString(), e);
		}finally{
			try {
				if(reader!=null){
					reader.close();
				}
				
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				logger.error(e.toString(), e);
			}
		}
		
        long end = System.currentTimeMillis();
        logger.info("read file cost time is=="+(end-start));
		
	}
}
