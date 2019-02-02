package com.example.todoapp.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.todoapp.models.Patient;
import com.example.todoapp.repositories.PatientCustomRepository;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class PatientCustomRepositoryImpl implements PatientCustomRepository{
	
	private static final String COLLECTION_NAME = "patient";
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Patient findByID(String patId) {
		// TODO Auto-generated method stub
		return  mongoTemplate.findOne(
		        Query.query(Criteria.where("_id").is(patId)),
		        Patient.class, COLLECTION_NAME
		    );
	}

}
