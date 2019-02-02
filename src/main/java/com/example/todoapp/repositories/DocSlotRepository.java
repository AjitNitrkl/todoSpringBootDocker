package com.example.todoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todoapp.models.DocSlot;

public interface DocSlotRepository extends MongoRepository<DocSlot, String> {

}
