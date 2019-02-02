package com.example.todoapp;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.todoapp.models.Hospital;
import com.example.todoapp.repositories.HospitalRepository;
import com.example.todoapp.service.TodoService;
import java.lang.Math;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoappApplicationTests {
	
	@Autowired
	TodoService service;
	
	@Autowired
	HospitalRepository hospitalRepo;

	@Test
	public void contextLoads() {
		Optional<Hospital> hospital = hospitalRepo.findById("1");
		ExecutorService ex = Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++) {

			
			//Runnable worker = new WorkerThread("" + i);
			//ex.execute(worker);
			
			Runnable worker =()->{
				hospital.get().setName("New Test  Hospital");
				//service.updateWithFindHospital("1",hospital.get());
				Hospital fetchedHospital = service.updateHospital("1", hospital.get());
				System.out.println("Fetched Hospital Version"+fetchedHospital.getVersion());
			};
			ex.execute(worker);
		}
		ex.shutdown();
        while (!ex.isTerminated()) {
        }
        System.out.println("Finished all threads");
		
	}
	
	class WorkerThread implements Runnable{
		
		private String command;
	    
	    public WorkerThread(String s){
	        this.command=s;
	    }

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Optional<Hospital> hospital = hospitalRepo.findById("1");
			hospital.get().setName("New Test mew Hospital");
			service.updateHospital("1", hospital.get());
			
		}
		
	}
	
	

}
