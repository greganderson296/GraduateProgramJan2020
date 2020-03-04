package com.mastek.Bank.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="JPA_ACCOUNT")
public class Account {
	
	
	int accountId;
	
	@FormParam("bankName")
	String bankName;
	
	@FormParam("accountNo")
	long accountNo;
	
	
	
	private Set<Customer> customerAssigned = new HashSet<>();
	
	
	@ManyToMany(mappedBy="accountAssigned")
	@XmlTransient
	public Set<Customer> getCustomerAssigned() {
		return customerAssigned;
	}
	
	

	public void setCustomerAssigned(Set<Customer> customerAssigned) {
		this.customerAssigned = customerAssigned;
	}
	
	private Set<Transaction> transactionHistory = new HashSet<>();
	
	
	@OneToMany(mappedBy="linkedAccount", cascade= CascadeType.ALL)
	@XmlTransient
	public Set<Transaction> getTransactionHistory() {
		return transactionHistory;
	}



	public void setTransactionHistory(Set<Transaction> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}



	public Account() {
		}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", bankName=" + bankName + ", accountNo=" + accountNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}
	
	

}
