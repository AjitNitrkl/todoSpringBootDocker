package com.example.todoapp.repositories;

import com.example.todoapp.models.Hospital;

public interface HospitalCustomRepository {
	
	Hospital findAndInsert(Long id);
	Hospital update(String id, Hospital hospital);
	Hospital updateWithFind(String id, Hospital hospital);


}
