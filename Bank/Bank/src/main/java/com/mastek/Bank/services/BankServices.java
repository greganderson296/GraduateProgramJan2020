package com.mastek.Bank.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.Bank.DAO.AccountJPADAO;
import com.mastek.Bank.DAO.CustomerJPADAO;
import com.mastek.Bank.DAO.TransactionJPADAO;
import com.mastek.Bank.DAO.TransferJPADAO;
import com.mastek.Bank.entities.Account;
import com.mastek.Bank.entities.Customer;
import com.mastek.Bank.entities.Transaction;
import com.mastek.Bank.entities.Transfer;

@Scope("singleton")
@Component

public class BankServices {
	
	public BankServices() {
		
	}
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	TransactionJPADAO traDAO;
	
	@Autowired
	BankServices banDAO;
	
	@Autowired
	TransferJPADAO transferDAO;
	

	@PostConstruct // initialization method of the class
	public void initalizeService() {
		System.out.println( "Service Initialized");
		
	}
	
	@PreDestroy //calls before shutting down the application
	public void terminatesService() {
		System.out.println("Service Terminated");
}
	
	@Transactional
	public Customer assignCustomerToAccount(int cusId, int accId) {
	Customer cus = cusDAO.findById(cusId).get();
	Account acc = accDAO.findById(accId).get();
	
	cus.getAccountAssigned().add(acc);
	cusDAO.save(cus);
	return cus;
	}
	
	@Transactional
	public Transaction assignTransactionToAccount(int traId, int accId) {
		Transaction tra = traDAO.findById(traId).get();
		Account acc = accDAO.findById(accId).get();
		
		tra.setLinkedAccount(acc);
		acc.getTransactionHistory().add(tra);
		traDAO.save(tra);
		accDAO.save(acc);
		return tra;
	}
	
	@Transactional
	public Transfer assignTransferToTransaction( int transferId, int transactionId) {
		Transfer tra = transferDAO.findById(transferId).get();
		Transaction tras = traDAO.findById(transactionId).get();
		
		tra.getRequests().add(tras);
		tra = transferDAO.save(tra);
		return(tra);
	}
	
}
