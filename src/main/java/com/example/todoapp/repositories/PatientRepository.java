package com.example.todoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.models.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

}