package com.example.todoapp.controllers;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloKafkaController {
 
//    private final KafkaTemplate<String, Object> template;
//    private final String topicName;
//    private final int messagesPerRequest;
//    private CountDownLatch latch;
 
//    public HelloKafkaController(
//            final KafkaTemplate<String, Object> template,
//            @Value("${tpd.topic-name}") final String topicName,
//            @Value("${tpd.messages-per-request}") final int messagesPerRequest) {
//        this.template = template;
//        this.topicName = topicName;
//        this.messagesPerRequest = messagesPerRequest;
//    }
// 
//    @GetMapping("/hello")
//    public String hello() throws Exception {
//        latch = new CountDownLatch(messagesPerRequest);
//        IntStream.range(0, messagesPerRequest)
//                .forEach(i -> this.template.send(topicName, String.valueOf(i),
//                        new PracticalAdvice("A Practical Advice", i))
//                );
//        latch.await(60, TimeUnit.SECONDS);
//        logger.info("All messages received");
//        return "Hello Kafka!";
//    }
}