package com.example.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.todoapp.kafka.service.impl.KafkaProducer;
import com.example.todoapp.models.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class KafkaService {
	
	 private final KafkaProducer producer;
	
	@Async("asyncExecutor")
	public void sendMsgToTopic(List<User> users) {
		 this.producer.sendMessage(users);
	}

}
