package com.mastek.Bank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="JPA_TRANSACTION")
public class Transaction {
	
	
	int transactionId;
	
	@FormParam("amount")
	double amount;
	
	@FormParam("paymentType")
	String paymentType;
	
	private Account linkedAccount;
	
	
	@ManyToOne
	@XmlTransient
	@JoinColumn(name="fk_account_number")
	public Account getLinkedAccount() {
		return linkedAccount;
	}

	public void setLinkedAccount(Account linkedAccount) {
		this.linkedAccount = linkedAccount;
	}

	public Transaction() {
		}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", paymentType=" + paymentType
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionId;
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
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}
	
	

}
