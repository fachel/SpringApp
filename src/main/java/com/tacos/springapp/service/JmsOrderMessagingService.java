//package com.tacos.springapp.service;
//
//import com.tacos.springapp.models.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import org.springframework.kafka.core.KafkaTemplate;
//
//@Service
//class KafkaOrderMessagingService  {
//    private KafkaTemplate<String, Order> kafkaTemplate;
////    @Bean
////    public KafkaTemplate myMessageKafkaTemplate() {
////        return new KafkaTemplate<String, Order>();
////    }
//
////    @Autowired
////    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafkaTemplate) {
////        this.kafkaTemplate = kafkaTemplate;
////    }
//
//    public void sendOrder(Order order) {
//        kafkaTemplate.send("tacocloud.orders.topic", order);
//    }
//}
