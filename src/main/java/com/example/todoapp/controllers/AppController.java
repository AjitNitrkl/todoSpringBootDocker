package com.example.todoapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.models.Hospital;
import com.example.todoapp.models.Patient;
import com.example.todoapp.models.Physician;
import com.example.todoapp.repositories.DocSlotRepository;
import com.example.todoapp.repositories.HospitalRepository;
import com.example.todoapp.repositories.PatientCustomRepository;
import com.example.todoapp.repositories.PatientRepository;
import com.example.todoapp.repositories.PhysicianRepository;
import com.example.todoapp.repositories.SlotInfoRepository;
import com.example.todoapp.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppController {
	
	 private final PatientRepository patientRepository;
	 
	 private final PhysicianRepository physicianRepository;
	 
	 private final HospitalRepository hospitalRepository;
	 
	 private final DocSlotRepository docSlotRepository;
	 
	 private final SlotInfoRepository slotInfoRepository;
	 
	 private final PatientCustomRepository patientCustomRepo;
	 
	 private final TodoService todoService;
	
	  @PostMapping("/patient")
	  public @Valid Patient addPatient(@Valid @RequestBody Patient patient) {
		 // hospitalRepository.save(patient.getHospital());
	        return patientRepository.save(patient);
	  }
	  
	  @PostMapping("/physician")
	  public @Valid Physician addHospital(@Valid @RequestBody Physician physician) {
		  	hospitalRepository.save(physician.getHospital());
		  	physician.getSlots().getSlotInfos().forEach(item->slotInfoRepository.save(item));
		  	docSlotRepository.save(physician.getSlots());
		  
	        return physicianRepository.save(physician);
	  }
	  
	  @GetMapping("/patient/{patId}")
	  public ResponseEntity<?> findPatientById(@PathVariable String patId){
			Patient patient = patientCustomRepo.findByID(patId);
			return new ResponseEntity<Patient>(patient,HttpStatus.OK);
		}
	  
	  @PostMapping("/hospital")
	  public @Valid Hospital addHospital(@Valid @RequestBody Hospital hospital) {
		  return hospitalRepository.save(hospital);
	  }
	  
	  @PostMapping("/hospital/{hospitalId}")
	  public @Valid Hospital updateHospital(@PathVariable String hospitalId, @Valid @RequestBody Hospital hospital) {
		  return todoService.updateHospital(hospitalId, hospital);
	  }
	  
	  

}
