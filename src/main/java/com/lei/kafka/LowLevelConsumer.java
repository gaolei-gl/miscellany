//package com.com.lei.kafka;
//
//
//import kafka.api.PartitionOffsetRequestInfo;
//import kafka.cluster.Broker;
//import kafka.common.TopicAndPartition;
//import kafka.javaapi.*;
//import kafka.javaapi.consumer.SimpleConsumer;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by com.lei on 15-6-14.
// */
//public class LowLevelConsumer {
//    public static void main(String[] args) {
//        SimpleConsumer consumer = new SimpleConsumer("dpkafka35.et2", 9092, 10000, 1024 * 1024, "groupid_test");
//        List<String> topics2 = new ArrayList<String>();
//        TopicMetadataRequest req = new TopicMetadataRequest(topics2);
//        TopicMetadataResponse resp = consumer.send(req);
//        List<TopicMetadata> data3 = resp.topicsMetadata();
//        for (TopicMetadata item : data3) {
//            System.out.println("Topic: " + item.topic());
//            for (PartitionMetadata part : item.partitionsMetadata()) {
//                String replicas = "";
//                String isr = "";
////                for (Broker replica : part.replicas()) {
////                    replicas += " " + replica.host();
////                }
////                for (Broker replica : part.isr()) {
////                    isr += " " + replica.host();
////                }
//                System.out.println("    Partition: " + part.partitionId() + ": Leader: " + part.leader().host() + " Replicas:[" + replicas + "] ISR:[" + isr + "]");
//            }
//        }
//
//        System.out.println(getEarliestOffsetPerParition("dpkafka43.et2","ualog",328,true));
//        System.out.println(getLatestOffsetPerPartition("dpkafka43.et2","ualog",328,true));
//
//    }
//
//    static long getEarliestOffsetPerParition(String broker, String topic, int partition, boolean printLog) {
//        SimpleConsumer consumer = new SimpleConsumer(broker, 9092, 10000, 1024 * 1024, "offset-fetcher-consumer-" + broker);
//        Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = Collections.singletonMap(new TopicAndPartition(topic, partition), new PartitionOffsetRequestInfo(kafka.api.OffsetRequest.EarliestTime(), 1));
//        kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(requestInfo, kafka.api.OffsetRequest.CurrentVersion(), "offset-fetcher-request-" + broker);
//        OffsetResponse response = consumer.getOffsetsBefore(request);
//        if (response.hasError()) {
//            throw new KafkaOffsetException("ErrorCode = " + response.errorCode(topic, partition) + "Can't get offset for " + topic + " at " + partition);
//        }
//        long[] offset = response.offsets(topic, partition);
//        if (printLog) {
//            System.out.println(("Use earliest offset [" + offset[0] + "] for " + topic + "-" + broker + "-" + partition));
//        }
//        return offset[0];
//    }
//
//
//    static long getLatestOffsetPerPartition(String broker, String topic, int partition, boolean printLog) {
//        SimpleConsumer consumer = new SimpleConsumer(broker, 9092, 10000, 1024 * 1024, "offset-fetcher-consumer-" + broker);
//        Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = Collections.singletonMap(new TopicAndPartition(topic, partition), new PartitionOffsetRequestInfo(kafka.api.OffsetRequest.LatestTime(), 1));
//        kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(requestInfo, kafka.api.OffsetRequest.CurrentVersion(), "offset-fetcher-request-" + broker);
//        OffsetResponse response = consumer.getOffsetsBefore(request);
//        if (response.hasError()) {
//            throw new KafkaOffsetException("ErrorCode = " + response.errorCode(topic, partition) + "Can't get offset for " + topic + " at " + partition);
//        }
//        long[] offset = response.offsets(topic, partition);
//        if (printLog) {
//            System.out.println(("Get latest offset [" + offset[0] + "] for " + topic + "-" + broker + "-" + partition));
//        }
//        return offset[0];
//    }
//
//
//}
