package com.example.mybatisredis.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        // 1. 配置消费者属性
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.101.129:9092");
        props.put("group.id", "test-group"); // 消费者组ID
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest"); // 从最早位置开始消费

        // 2. 创建消费者实例
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            // 3. 订阅主题
            String topic = "test";
            consumer.subscribe(Collections.singletonList(topic));

            // 4. 循环消费消息
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                records.forEach(record -> {
                    System.out.println("收到消息：" +
                            "键=" + record.key() +
                            ", 值=" + record.value() +
                            ", 分区=" + record.partition() +
                            ", 偏移量=" + record.offset());
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                });
            }
        }
    }
}
