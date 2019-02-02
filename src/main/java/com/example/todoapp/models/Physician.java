package com.example.todoapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Document(collection="physician")
public class Physician {
	
	 @Id
	 private String id;
	 private String fname;
	 private String lname;
	 private String degree;
	 private String speciality;
	 @DBRef
	 private Hospital hospital;
	 @DBRef
	 private DocSlot slots;
	 
	 
}
