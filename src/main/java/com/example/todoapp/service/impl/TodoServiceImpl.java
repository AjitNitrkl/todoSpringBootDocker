package com.example.todoapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.todoapp.models.Hospital;
import com.example.todoapp.repositories.HospitalCustomRepository;
import com.example.todoapp.service.TodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	HospitalCustomRepository hospitalCustRepo;

	@Override
	public Hospital updateHospital(String hospitalId, Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalCustRepo.update(hospitalId, hospital);
	}
	
	@Override
	public Hospital updateWithFindHospital(String hospitalId, Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalCustRepo.updateWithFind(hospitalId, hospital);
	}
	

}
