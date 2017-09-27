package com.junhzhan.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		Properties props = new Properties();
//		props.put("bootstrap.servers", "121.41.102.224:9092");
//		props.put("group.id", "aaaaa");
//		props.put("enable.auto.commit", "true");
//		props.put("auto.commit.interval.ms", "1000");
//		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//		consumer.subscribe(Arrays.asList("test", "my-replicated-topic"));
//		while (true) {
//			logger.info("before poll");
//			ConsumerRecords<String, String> records = consumer.poll(100);
//			logger.info("after poll");
//			logger.info("poll ");
//			for (ConsumerRecord<String, String> record : records)
//				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//		}
	}

}
