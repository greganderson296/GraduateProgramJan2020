package com.mastek.Bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_JOINED_TABLE_CARLOAN")//to define the table for each derived class
@DiscriminatorValue("CAR")//value to be stored in payment type for card payment objects

public class CarLoan extends Loan{
	
	int carLoanNo;
	String carType;
	int carYear;
	
	
	public int getCarLoanNo() {
		return carLoanNo;
	}
	public void setCarLoanNo(int carLoanNo) {
		this.carLoanNo = carLoanNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	@Override
	public String toString() {
		return "CarLoan [carLoanNo=" + carLoanNo + ", carType=" + carType + ", carYear=" + carYear + ", loanId="
				+ loanId + ", value=" + value + ", duration=" + duration + "]";
	}
	
	
	
	

}
