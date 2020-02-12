package com.mastek.Bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_JOINED_TABLE_HOMELOAN")//to define the table for each derived class
@DiscriminatorValue("HOME")//value to be stored in payment type for card payment objects

public class HomeLoan extends Loan{
	
	int homeLoanNo;
	String homeType;
	int homeAge;
	public int getHomeLoanNo() {
		return homeLoanNo;
	}
	public void setHomeLoanNo(int homeLoanNo) {
		this.homeLoanNo = homeLoanNo;
	}
	public String getHomeType() {
		return homeType;
	}
	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}
	public int getHomeAge() {
		return homeAge;
	}
	public void setHomeAge(int homeAge) {
		this.homeAge = homeAge;
	}
	@Override
	public String toString() {
		return "HomeLoan [homeLoanNo=" + homeLoanNo + ", homeType=" + homeType + ", homeAge=" + homeAge + ", loanId="
				+ loanId + ", value=" + value + ", duration=" + duration + "]";
	}
	
	

}
