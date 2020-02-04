package com.mastek.training.hrapp;

public class SalesEmployee extends Employee {
//Each class specifies their base/parent class name using extends keyword
	//if the class does not have extends keyword it is by default inheriting java.lang.object
	
	private long target;
	private double comission;
	
	public SalesEmployee() {
		//use super keyword to call the base class constructor from the child/derived class
		//super constructor call must be the first line in the constructor
		super(7777, "SalesExample", 99, Designations.Officer);
		System.out.println("Sales Employee Created");
		
		
	}
	
	//method Overriding 
	// We write the same method available in base class in child class with different
	// or additional logic for processing the result
	@Override
	public double getNetSalary(int noOfDays) throws Exception {
		// TODO Auto-generated method stub
		return (super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getComission()));
	}
	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getComission() {
		return comission;
	}
	public void setComission(double comission) {
		this.comission = comission;
	}
	
}
