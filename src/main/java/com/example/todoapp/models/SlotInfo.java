package com.example.todoapp.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SlotInfo {
	@Id
	private String id;
	private String desc;
	private int order;
	private Date startTime = new Date();
	private Date endTime = new Date();
	public enum STATUS {
	       NONE, SCHEDULED, PROCESSING, COMPLETE;
	};
	private STATUS status;
	

}
