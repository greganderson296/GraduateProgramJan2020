package com.mastek.Bank.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.Bank.entities.Account;


@Repository
public interface AccountJPADAO extends CrudRepository<Account, Integer>{

}
