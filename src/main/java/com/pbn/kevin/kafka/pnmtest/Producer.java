package com.pbn.kevin.kafka.pnmtest;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author kevin
 * @version 创建时间: 2018年4月2日下午3:05:25
 * @ClassName 类名称
 * @Description 类描述
 */
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
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Boolean isAsync;

    /**
     * 实例化生产者时，有三个配置是必须指定的：
     * @param topic
     * @param isAsync
     */
    public Producer(String topic, Boolean isAsync) {
        Properties props = new Properties();
        /**bootstrap.servers:配置连接代理列表
        	* 不必包含Kafka集群的所有代理地址，当连接上一个代理后，会从集群元数据信息中获取其他存活的代理信息。
        	* 但为了保证能够成功连上Kafka集群，在多代理集群的情况下，建议至少配置两个代理。
        	*/
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.22.200:9092,192.168.22.201:9092,192.168.22.202:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "");
        //key.serializer ： 用于序列化消息Key的类
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        //value.serializer ：用于序列化消息值（Value）的类
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");
        //请求的最大字节数
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 3000000);
        producer = new KafkaProducer<>(props);
        this.topic = topic;
        this.isAsync = isAsync;
    }

    public void send(String message) {
    		if (isAsync) { // Send asynchronously
            producer.send(new ProducerRecord<Integer, String>(topic, message),new DemoCallBack(message));
        } else { // Send synchronously
            try {
                producer.send(new ProducerRecord<>(topic,message)).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void close() {
    		producer.close();
    }
}


class DemoCallBack implements Callback {

    private final String message;

    public DemoCallBack(String message) {
        this.message = message;
    }

    /**
     * A callback method the user can implement to provide asynchronous handling of request completion. This method will
     * be called when the record sent to the server has been acknowledged. Exactly one of the arguments will be
     * non-null.
     *
     * @param metadata  The metadata for the record that was sent (i.e. the partition and offset). Null if an error
     *                  occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (metadata != null) {
        } else {
            exception.printStackTrace();
        }
    }
}