package com.pbn.kevin.kafka;
/**
 * @author kevin
 * @version 创建时间: 2018年4月2日下午2:33:15
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

public class KafkaProperties {
	public static final String TOPIC1 = "test1";
    public static final String KAFKA_SERVER_URL = "192.168.16.179";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final String ZOOKEEPER_SERVERS = "192.168.16.179:2181";
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final int SESSION_TIMEOUT = 100000;

    private KafkaProperties() {}
}
