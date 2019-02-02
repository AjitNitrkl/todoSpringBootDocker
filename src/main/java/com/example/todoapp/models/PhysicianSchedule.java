package com.example.todoapp.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Document(collection="physicianschedule")
public class PhysicianSchedule {
	
	 @Id
	 private String id;
	 @DBRef(db="physician")
	 private String physicianId;
	 @DBRef(db="patient")
	 private String patientId;
	 private Date serviceDate;

}
