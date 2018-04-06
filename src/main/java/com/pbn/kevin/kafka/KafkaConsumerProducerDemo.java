package com.pbn.kevin.kafka;
/**
 * @author kevin
 * @version 创建时间: 2018年4月2日下午2:35:57
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

public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
//        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
        boolean isAsync = true;
        Producer producerThread = new Producer(KafkaProperties.TOPIC1, isAsync);
        producerThread.start();

        ConsumerOld consumer = new ConsumerOld(KafkaProperties.TOPIC1);
        consumer.start();
        
        ConsumerOld2 consumer2 = new ConsumerOld2(KafkaProperties.TOPIC1);
        consumer2.start();
        
    }
}