package com.mastek.Bank.services;

import java.util.Set;

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
import com.mastek.Bank.api.AccountAPI;
import com.mastek.Bank.api.CustomerAPI;
import com.mastek.Bank.api.TransactionAPI;
import com.mastek.Bank.entities.Account;
import com.mastek.Bank.entities.Customer;
import com.mastek.Bank.entities.Transaction;
import com.mastek.Bank.entities.Transfer;



@Scope("singleton")
@Component

public class BankServices  implements AccountAPI, CustomerAPI, TransactionAPI{
	
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

	@Override
	public Iterable<Transaction> listAllTransactions() {
		return traDAO.findAll();
	}

	@Override
	public Transaction findByTransactionId(int transactionId) {
		
		return traDAO.findById(transactionId).get();
	}

	@Override
	public Transaction registerNewTransaction(Transaction newTransaction) {
		newTransaction = traDAO.save(newTransaction);
		return newTransaction;
	}

	@Override
	public Iterable<Customer> listAllCustomers() {
		return cusDAO.findAll();
	}

	@Override
	public Customer findByCustomerId(int customerId) {
		return cusDAO.findById(customerId).get();
	}

	@Override
	public Customer registerNewCustomer(Customer newCustomer) {
		newCustomer = cusDAO.save(newCustomer);
		return newCustomer;
	}

	@Override
	public Iterable<Account> listAllAccounts() {
		return accDAO.findAll();
	}

	@Override
	public Account findByAccountId(int accountId) {
		return accDAO.findById(accountId).get();
	}

	@Override
	public Account registerNewAccount(Account newAccount) {
		newAccount = accDAO.save(newAccount);
		return newAccount;
	}

	@Override
	@Transactional 
	public Set<Account> getCustomerAccounts(int custId) {
		Customer currentCust = cusDAO.findById(custId).get();
		int count = currentCust.getAccountAssigned().size();
		System.out.println(count +" Accounts found");
		
		Set<Account> accounts = currentCust.getAccountAssigned();
		return accounts;
	}

	@Override
	@Transactional
	public Account registerAccountForCustomer(int custId, Account newAccount) {
		newAccount = accDAO.save(newAccount);
		assignCustomerToAccount(custId, newAccount.getAccountId());
		return newAccount;
	}
	
	
	
	
	
	
	@Override
	@Transactional
	public Set<Transaction> getAccountTransactions(int accountId) {
		Account currentAcc = accDAO.findById(accountId).get();
		int count = currentAcc.getTransactionHistory().size();
		
		System.out.println(count +" Transactions found");
		Set<Transaction>transactions = currentAcc.getTransactionHistory();
		return transactions;
	}

	@Override
	@Transactional
	public Transaction registerTransactionForAccount(int accountId, Transaction newTransaction) {
		newTransaction = traDAO.save(newTransaction);
		assignTransactionToAccount(accountId, newTransaction.getTransactionId());
		return newTransaction;
	}
	
}
