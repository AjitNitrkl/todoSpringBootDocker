package com.example.todoapp.models;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Document(collection="patient")
public class Patient {
	
	 @Id
	 private String id;
	 private String fName;
	 private String lName;
	 private String mobile;
	 private String email;
//	 @DBRef(db="physician")
//	 private String physicianId;
//	 @DBRef(db="hospital")
//	 @CascadeSave
//	 private Hospital hospital;
	 private Date serviceDate = new Date();
	 private SlotInfo slotInfo;
	 
}
