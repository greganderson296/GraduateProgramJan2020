package com.mastek.Bank.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity

@Table(name = "JPA_JOINED_LOAN")//define single table in base class
@Inheritance(strategy = InheritanceType.JOINED)//choose a single table strategy

@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="LOAN_TYPE")
@DiscriminatorValue("LOAN")//value to be stored for payment objects in Payment_type column

public class Loan {
	
	int loanId;
	double value;
	int duration;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", value=" + value + ", duration=" + duration + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loanId;
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
		Loan other = (Loan) obj;
		if (loanId != other.loanId)
			return false;
		return true;
	}
	
	
	
	

}
