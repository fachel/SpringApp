//package com.tacos.springapp.integration;
//
//import java.io.File;
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.Router;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.dsl.MessageChannels;
//import org.springframework.integration.file.dsl.Files;
//import org.springframework.integration.file.support.FileExistsMode;
//import org.springframework.integration.router.AbstractMessageRouter;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//
//@Configuration
//public class FileWriterIntegrationConfig {
//    @Bean
//    public IntegrationFlow fileWriterFlow() {
//        return IntegrationFlows
//                .from(MessageChannels.direct("textInChannel")) //Входящий канал
//                .route(evenOddRouter())
//                .<String, String>transform(t -> t.toUpperCase()) //Объявление transformer
//                .handle(Files                      //Обрабатывает запись в файл
//                        .outboundAdapter(new File("/com.tacos.springapp.integration/files"))
//                        .fileExistsMode(FileExistsMode.APPEND)
//                        .appendNewLine(true))
//
//                .get();
//    }
//    @Bean
//    @Router(inputChannel="numberChannel")
//    public AbstractMessageRouter evenOddRouter() {
//        return new AbstractMessageRouter() {
//            @Override
//            protected Collection<MessageChannel>
//            determineTargetChannels(Message<?> message) {
//                Integer number = (Integer) message.getPayload();
//                if (number % 2 == 0) {
//                    return Collections.singleton(evenChannel());
//                }
//                return Collections.singleton(oddChannel());
//            }
//        };
//    }
//
//    @Bean
//    public MessageChannel evenChannel() {
//        return new DirectChannel();
//    }
//    @Bean
//    public MessageChannel oddChannel() {
//        return new DirectChannel();
//    }
//}
