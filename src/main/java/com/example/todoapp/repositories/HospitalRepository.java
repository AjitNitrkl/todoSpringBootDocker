package com.example.todoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.models.Hospital;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {

}