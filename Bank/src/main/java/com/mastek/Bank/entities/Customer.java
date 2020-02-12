package com.mastek.Bank.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Customer")
public class Customer {
	
	int custId;
	String name;
	String address;
	
	private Set<Account> accountAssigned = new HashSet<>();
	
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name= "JPA_ACCOUNT_ASIGNMENTS",
	joinColumns= {@JoinColumn(name="fk_CusId")}, 
	inverseJoinColumns= {@JoinColumn(name="fk_AccId")}) 
	public Set<Account> getAccountAssigned() {
		return accountAssigned;
	}

	public void setAccountAssigned(Set<Account> accountAssigned) {
		this.accountAssigned = accountAssigned;
	}

	public Customer() {
		}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
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
		Customer other = (Customer) obj;
		if (custId != other.custId)
			return false;
		return true;

	
	
	}
}
