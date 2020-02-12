package com.mastek.Bank.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.Bank.entities.Transaction;


@Repository
public interface TransactionJPADAO extends CrudRepository<Transaction, Integer>{

}
