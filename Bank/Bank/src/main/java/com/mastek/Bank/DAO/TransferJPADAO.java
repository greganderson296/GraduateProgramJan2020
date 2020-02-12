package com.mastek.Bank.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mastek.Bank.entities.Transfer;

public interface TransferJPADAO extends MongoRepository<Transfer, Integer>{
	//map the document and identifier type with MongoRepository

}
