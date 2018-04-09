package com.pbn.kevin.kafka;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.common.security.JaasUtils;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;

/**
 * @author kevin
 * @version 创建时间: 2018年4月6日下午6:12:58
 * @ClassName 类名称
 * @Description 类描述
 */
public class KakfkaTopicMgt {
	public static void main(String[] args) throws Exception {
//		delTopic("test1");
//		addTopic("portal1", 1, 1);
//		List<String> topicList = getTopicList();
//		System.err.println(topicList);
	}
	
	public static void addTopic(String topicName,int partitions,int replication) {
		ZkUtils zkUtils = ZkUtils.apply(KafkaProperties.ZOOKEEPER_SERVERS, KafkaProperties.SESSION_TIMEOUT, KafkaProperties.CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
		// 创建一个两分区单副本名为t1的topic
		AdminUtils.createTopic(zkUtils, topicName, partitions, replication, new Properties(), RackAwareMode.Enforced$.MODULE$);
		zkUtils.close();
	}
	public static void delTopic(String topicName) {
		ZkUtils zkUtils = ZkUtils.apply(KafkaProperties.ZOOKEEPER_SERVERS, KafkaProperties.SESSION_TIMEOUT, KafkaProperties.CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
		AdminUtils.deleteTopic(zkUtils, topicName);
		zkUtils.close();
	}
	public static void selectTopic(String topicName) {
		ZkUtils zkUtils = ZkUtils.apply(KafkaProperties.ZOOKEEPER_SERVERS, KafkaProperties.SESSION_TIMEOUT, KafkaProperties.CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
		// 获取topic 'test'的topic属性属性
		Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topicName);
		// 查询topic-level属性
		Iterator it = props.entrySet().iterator();
		while(it.hasNext()){
		    Map.Entry entry=(Map.Entry)it.next();
		    Object key = entry.getKey();
		    Object value = entry.getValue();
		    System.err.println(key + " = " + value);
		}
		zkUtils.close();
	}
	public static void updateTopic() {
		ZkUtils zkUtils = ZkUtils.apply(KafkaProperties.ZOOKEEPER_SERVERS, KafkaProperties.SESSION_TIMEOUT, KafkaProperties.CONNECTION_TIMEOUT, JaasUtils.isZkSecurityEnabled());
		Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), "test");
		// 增加topic级别属性
		props.put("min.cleanable.dirty.ratio", "0.3");
		// 删除topic级别属性
		props.remove("max.message.bytes");
		// 修改topic 'test'的属性
		AdminUtils.changeTopicConfig(zkUtils, "test", props);
		zkUtils.close();
	}
	
	public static List<String> getTopicList() throws Exception{
		ZooKeeper zooKeeper = new ZooKeeper(KafkaProperties.ZOOKEEPER_SERVERS, KafkaProperties.SESSION_TIMEOUT, new Watcher() {
			@Override
			public void process(WatchedEvent arg0) {
				System.err.println("process================");
			}
		});
        List<String> list = zooKeeper.getChildren("/brokers/topics", false);
        list.remove("__consumer_offsets");
        zooKeeper.close();
        return list;
	}
}
