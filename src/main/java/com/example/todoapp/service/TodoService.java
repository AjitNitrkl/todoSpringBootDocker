package com.example.todoapp.service;

import com.example.todoapp.models.Hospital;

public interface TodoService {
	
	Hospital updateHospital(String hospitalId, Hospital hospital);
	Hospital updateWithFindHospital(String hospitalId, Hospital hospital);

}
