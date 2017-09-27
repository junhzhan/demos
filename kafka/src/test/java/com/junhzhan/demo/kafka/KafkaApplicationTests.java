package com.junhzhan.demo.kafka;

import jdk.nashorn.internal.ir.FunctionCall;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

    Logger logger = LoggerFactory.getLogger(KafkaApplicationTests.class);
	@Test
	public void publish() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "121.41.102.224:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 100; i++) {
			Future<RecordMetadata> result = producer.send(new ProducerRecord<String, String>("my-replicated-topic", Integer.toString(i), Integer.toString(i)));
			try {

				RecordMetadata metadata = result.get();
				logger.info("message offset is {}", metadata.offset());
			} catch (Exception e) {
				logger.error("error is ", e);
			}
		}
		producer.flush();

		producer.close();
	}

	@Test
	public void consume() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "121.41.102.224:9092");
		props.put("group.id", "aaaaa");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("test", "my-replicated-topic"));
		while (true) {
			logger.info("before poll");
			ConsumerRecords<String, String> records = consumer.poll(1000);
			logger.info("after poll");
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
		}
	}

}
