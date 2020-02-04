package com.mastek.training.passport;

public class Passport {
	
	public int Pasno;
	public String firstName;
	public String lastName;
	public int expiry;
	
	{
		setPasno(111);
		setFirstName("john");
		setLastName("Smith");
		setExpiry(2019);
	}
	
	
	
	public int getPasno() {
		return Pasno;
	}
	public void setPasno(int pasno) {
		Pasno = pasno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getExpiry() {
		return expiry;
	}
	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	
	
	
	
	
	
	

}
