package com.kevin.kafka.pnmtest;
/**
 * @author kevin
 * @version 创建时间: 2018年4月2日下午2:35:05
 * @ClassName 类名称
 * @Description 类描述
 */

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.pbn.framework.proxy.ProxyMgntService;

import kafka.utils.ShutdownableThread;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class CMConsumer extends ShutdownableThread {

	private static final Logger logger = LoggerFactory.getLogger(CMConsumer.class);

	private final KafkaConsumer<Integer, String> consumer;
	private final String topic;

	public CMConsumer(String topic, String groupId) {
		super("", false);
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.22.200:9092,192.168.22.201:9092,192.168.22.202:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.IntegerDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");

		consumer = new KafkaConsumer<>(props);
		this.topic = topic;
	}

	@Override
	public void doWork() {
		consumer.subscribe(Collections.singletonList(this.topic));
		ConsumerRecords<Integer, String> records = consumer.poll(1000);
		for (ConsumerRecord<Integer, String> record : records) {
//			JsonNode jsonNode = Convert.parse((String)(record.value()));
			System.out.println("receive proxy message for cm ==="+record.value());
//			if (jsonNode.has("header")) {
//				if (jsonNode.get("header").get("opCode").asText().equals("1")) {
//					ObjectNode json = Convert.newObject();
//					ObjectNode cmObj = (ObjectNode) jsonNode.get("body").get("data");
//					cmObj.put("mac_ADDR", cmObj.get("mac").asText());
//					json.put("messageName", "WssPNMResponse");
//					json.put("messageType", "kafka");
//					json.set("cmObj", cmObj);
//					Global.getPnmMaster().tell(json,ActorRef.noSender());
//				}
//			}
		}
	}

	@Override
	public String name() {
		return null;
	}

	@Override
	public boolean isInterruptible() {
		return false;
	}

	public void close() {
		consumer.close();
	}
}