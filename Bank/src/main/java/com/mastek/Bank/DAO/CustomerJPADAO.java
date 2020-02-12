package com.mastek.Bank.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.Bank.entities.Customer;


@Repository
public interface CustomerJPADAO extends CrudRepository<Customer, Integer>{

}
