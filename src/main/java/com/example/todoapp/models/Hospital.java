package com.example.todoapp.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Document(collection="hospital")
public class Hospital {
	
	 @Id
	 private String id;
	 private String name;
	 private String contact;
	 private Address address;
	 @Version
	 private Long version;
}
