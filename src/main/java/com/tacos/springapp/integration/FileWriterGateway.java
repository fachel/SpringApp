//package com.tacos.springapp.integration;
//
//import org.springframework.integration.annotation.MessagingGateway;
//import org.springframework.integration.file.FileHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//@MessagingGateway(defaultRequestChannel="textInChannel") //Объявляет шлюз сообщений
//public interface FileWriterGateway {
//    void writeToFile(@Header(FileHeaders.FILENAME) String filename,String data); //Пишет в файл
//}
