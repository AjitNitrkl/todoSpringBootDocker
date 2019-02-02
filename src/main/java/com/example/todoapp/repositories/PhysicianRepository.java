package com.example.todoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.models.Physician;

@Repository
public interface PhysicianRepository extends MongoRepository<Physician, String> {

}
