package com.example.mybatisredis.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {


    public static void main(String[] args) {
        System.out.println("驱动类加载成功！已成功引入达梦驱动。");

        // 1. 配置生产者属性
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.101.129:9092"); // Kafka broker地址
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 2. 创建生产者实例
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            // 3. 发送消息
            String topic = "test";
            String key = "key1";
            String value = "Hello, Kafka from Java!";

            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("消息发送成功：" +
                            "主题=" + metadata.topic() +
                            ", 分区=" + metadata.partition() +
                            ", 偏移量=" + metadata.offset());
                } else {
                    System.err.println("消息发送失败：" + exception.getMessage());
                }
            });

            // 确保消息被发送
            producer.flush();
        }
    }
}
