package com.example.todoapp.repositories;

import com.example.todoapp.models.Patient;

public interface PatientCustomRepository {
	
	Patient findByID(String patId);

}
