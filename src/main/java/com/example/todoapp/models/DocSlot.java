package com.example.todoapp.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DocSlot {
	
	@Id
	private String id;
	
	private Date slotStartTime = new Date();
	private Date slotEndTime = new Date();
	public enum APP_TYPE {
	       FIFO, SLOT;
	};

	private APP_TYPE appointType;
	private int frequency;
	private int slotCount;
	@DBRef
	private List<SlotInfo> slotInfos;
	

}
