package com.example.todoapp.controllers;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.models.Response;
import com.example.todoapp.models.User;
import com.example.todoapp.service.KafkaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/kafka")
@CrossOrigin("*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaController {

    private final KafkaService kafkaService;

//    @PostMapping(value = "/publish")
//    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
//        this.producer.sendMessage(message);
//    }
    
    @PostMapping(value = "/data")
    public CompletableFuture<Response>  sendMessage(@Valid @RequestBody List<User> users) {
        this.kafkaService.sendMsgToTopic(users);
        return CompletableFuture.completedFuture(Response.builder()
        		.responseId(UUID.randomUUID().toString())
        		.status("SUCCESS").build());
    }
}