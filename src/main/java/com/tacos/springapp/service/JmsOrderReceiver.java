//package com.tacos.springapp.service;
//
//import com.tacos.springapp.models.Order;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//class OrderListener {
//    Logger log = LoggerFactory.getLogger(OrderListener.class);
//    @KafkaListener(topics="tacocloud.orders.topic")
//    public void handle(Order order) {
//        log.info("message" + order);
//    }
//}
