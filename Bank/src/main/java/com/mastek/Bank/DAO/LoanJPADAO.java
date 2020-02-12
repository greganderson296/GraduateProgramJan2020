package com.mastek.Bank.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.Bank.entities.Loan;



@Repository
public interface LoanJPADAO extends CrudRepository<Loan, Integer> {

}


