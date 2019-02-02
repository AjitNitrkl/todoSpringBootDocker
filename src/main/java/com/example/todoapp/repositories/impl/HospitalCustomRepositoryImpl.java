package com.example.todoapp.repositories.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.todoapp.models.Hospital;
import com.example.todoapp.repositories.HospitalCustomRepository;
import com.mongodb.client.result.UpdateResult;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class HospitalCustomRepositoryImpl implements HospitalCustomRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final String COLLECTION_NAME = "hospital";

	public Hospital findAndInsert(Long id) {

		return mongoTemplate.findAndModify(
                new Query(where("id").is(id)),
                Update.update("id", id),
                FindAndModifyOptions.options().upsert(true).returnNew(true),
                Hospital.class
        );
	}
	
	public Hospital update(String hospitalId, Hospital hospital) {
		Query query = new Query(Criteria.where("_id").is(hospitalId));
		Update update = new Update().set("name", hospital.getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateResult result = mongoTemplate.upsert(query, update, Hospital.class);
		System.out.println("# of records modified "+result.getModifiedCount());
		return  mongoTemplate.findOne(
		        Query.query(Criteria.where("_id").is(hospitalId)),
		        Hospital.class, COLLECTION_NAME
		    );
	}
	
	public Hospital updateWithFind(String hospitalId, Hospital hospital) {
		System.out.println("Executing Thread "+Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mongoTemplate.findAndModify(
                new Query(where("id").is(hospitalId)),
                Update.update("name",hospital.getName()+Thread.currentThread().getName()+getDetails()),
                FindAndModifyOptions.options().upsert(true).returnNew(true),
                Hospital.class
        );
	}

	private String getDetails() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
