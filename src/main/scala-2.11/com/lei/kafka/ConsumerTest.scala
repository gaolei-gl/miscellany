package com.lei.kafka

import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}

import scala.collection.JavaConversions._

/**
  * Created by com.lei on 16-4-5.
  */
object ConsumerTest {
  def main(args: Array[String]) {

    val props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "test");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "10000");
    props.put("session.timeout.ms", "30000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    val consumer = new KafkaConsumer[String, String](props);
    consumer.subscribe(util.Arrays.asList("test_topic"));
    while (true) {
      val records: ConsumerRecords[String, String] = consumer.poll(5000)
      for (record: ConsumerRecord[String, String] <- records.records("test_topic")) {
        Console.out.println(s"offset = ${record.offset()}, key = ${record.key()}, value = ${record.value()}")
      }

    }
  }
}