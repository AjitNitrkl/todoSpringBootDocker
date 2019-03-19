package com.example.todoapp.kafka.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.todoapp.models.User;

//@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "user";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

//    public void sendMessage(String message) {
//        logger.info(String.format("#### -> Producing message -> %s", message));
//        this.kafkaTemplate.send(TOPIC, message);
//    }
    
    public void sendMessage(List<User> users) {
       
        users.stream()
        .filter(user -> user.getMobile().startsWith("+1"))
        .forEach(user->{
        try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info(String.format("#### -> Producing message -> %s", user));	
        kafkaTemplate.send(TOPIC,user);
    });        
       // this.kafkaTemplate.send(TOPIC, user);
    }
}