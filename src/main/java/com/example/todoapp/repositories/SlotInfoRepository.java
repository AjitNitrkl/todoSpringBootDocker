package com.example.todoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todoapp.models.SlotInfo;

public interface SlotInfoRepository extends MongoRepository<SlotInfo, String> {

}
