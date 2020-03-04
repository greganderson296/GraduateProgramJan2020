package com.mastek.Bank;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.Bank.DAO.AccountJPADAO;
import com.mastek.Bank.DAO.CustomerJPADAO;
import com.mastek.Bank.DAO.LoanJPADAO;
import com.mastek.Bank.DAO.TransactionJPADAO;
import com.mastek.Bank.DAO.TransferJPADAO;
import com.mastek.Bank.entities.Account;
import com.mastek.Bank.entities.CarLoan;
import com.mastek.Bank.entities.Customer;
import com.mastek.Bank.entities.HomeLoan;
import com.mastek.Bank.entities.Loan;
import com.mastek.Bank.entities.Transaction;
import com.mastek.Bank.entities.Transfer;
import com.mastek.Bank.services.BankServices;



@SpringBootTest
class BankApplicationTests {
	
	@Autowired
	BankServices banDAO;
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	TransactionJPADAO traDAO;
	
	@Autowired
	LoanJPADAO loanDAO;

	@Autowired
	TransferJPADAO transDAO;
	
	//@Test
	void testAddCustomer() {
		Customer cus = new Customer();
		cus.setName("Steve");
		cus.setAddress("Steve Street");
		
		cus = cusDAO.save(cus);
		System.out.println(cus);
		assertNotNull(cus, "Customer not Added");
	}
	
	//@Test
	void testAddAccount() {
		Account acc = new Account();
		acc.setBankName("RBS");
		acc.setAccountNo(1200000000);
		
		acc = accDAO.save(acc);
		System.out.println(acc);
		assertNotNull(acc, "Account not Added");
	}
	
	//@Test
	void testAddTransaction() {
		Transaction tra = new Transaction();
		tra.setAmount(1.5);
		tra.setPaymentType("Card");
		
		tra = traDAO.save(tra);
		System.out.println(tra);
		assertNotNull(tra, "Transaction not Added");
	}
	
	@Test
	void testAssignAccountToCustomer() {
		Customer cus = banDAO.assignCustomerToAccount(157, 85);
		assertTrue(cus.getAccountAssigned().size()>0,"Customer not Assigned");
	}
	
	//@Test
	void testAssignTransactionToAccount() {
	Transaction tra = banDAO.assignTransactionToAccount(86, 85);
	assertNotNull(tra.getLinkedAccount(),"Account not Assigned");
	}
	
	//@Test
		void testLoanAdd() {
			Loan loan = new Loan();
			loan.setValue(12.5);
			loan.setDuration(5);
			loan= loanDAO.save(loan);
			
			System.out.println(loan);
			assertNotNull(loan, "Loan Not Saved");
			
			
			
		}
		
		//@Test
		void testHomeLoanAdd() {
			HomeLoan hloan = new HomeLoan();
			hloan.setHomeType("Flat");
			hloan.setHomeAge(13);
			
			
			hloan= loanDAO.save(hloan);
			
			System.out.println(hloan);
			assertNotNull(hloan, "Home Loan Not Saved");
			
			
			
		}
		
		//@Test
		void testCarLoanAdd() {
			CarLoan cloan = new CarLoan();
			cloan.setCarType("Ferrari");
			cloan.setCarYear(2012);
			
			
			cloan= loanDAO.save(cloan);
			
			System.out.println(cloan);
			assertNotNull(cloan, "Car Loan Not Saved");
			
			
			
		}
		
		//@Test
		void testTransferAdd() {
			Transfer trans = new Transfer();
			trans.setTransferId(1);
			trans.setFromAccount("Joe");
			trans.setToAccount("Greg");
			trans.setAmount(120.2);
			trans.setDescription("Bet");
			
			trans=transDAO.save(trans);
			System.out.println(trans);
			assertNotNull(trans, "Transfer not Added");
		}
		
		//@Test
		void testTransferRequests() {
			
			Transfer trans = banDAO.assignTransferToTransaction(1, 92);
			//assertNotNull(trans, "Transfer Request not Recieved");
			for (Transaction trafs : trans.getRequests()) {
				System.out.println(trafs);
				
			}

		}
}
