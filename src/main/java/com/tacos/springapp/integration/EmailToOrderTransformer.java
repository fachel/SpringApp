//package com.tacos.springapp.integration;
//
//import com.tacos.springapp.models.Order;
//import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailToOrderTransformer
//        extends AbstractMailMessageTransformer<Order> {
//    @Override
//    protected AbstractIntegrationMessageBuilder<Order> doTransform(Message mailMessage)
//            throws Exception {
//        Order tacoOrder = processPayload(mailMessage);
//        return MessageBuilder.withPayload(tacoOrder);
//    }
//
//}