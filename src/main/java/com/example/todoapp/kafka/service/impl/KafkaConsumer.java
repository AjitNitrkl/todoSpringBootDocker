package com.example.todoapp.kafka.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.todoapp.models.User;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

//    @KafkaListener(topics = "user", groupId = "group_id")
//    public void consume(String message) throws IOException {
//        logger.info(String.format("#### -> Consumed message -> %s", message));
//    }
    
    
    @KafkaListener(topics = "user", groupId = "group_id")
    public void consume(User user) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", user));
    }
}