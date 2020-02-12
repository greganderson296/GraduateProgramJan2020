package com.mastek.Bank.entities;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="JPA_TRANSFER_REQUEST")
public class Transfer {
	
	int transferId;
	String fromAccount;
	String toAccount;
	double amount;
	String description;
	
	Set<Transaction> requests = new HashSet<>();
	
	
	
	public Set<Transaction> getRequests() {
		return requests;
	}
	public void setRequests(Set<Transaction> requests) {
		this.requests = requests;
	}
	
	
	@Id
	public int getTransferId() {
		return transferId;
	}
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Transfer [transferId=" + transferId + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", amount=" + amount + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transferId;
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
		Transfer other = (Transfer) obj;
		if (transferId != other.transferId)
			return false;
		return true;
	}
	
	

}
