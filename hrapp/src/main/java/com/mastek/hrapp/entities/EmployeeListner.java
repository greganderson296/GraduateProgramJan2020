package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component 
public class EmployeeListner {
	
	//@<lifecycle-Event>
	//public void <method-name>
	
	@PrePersist // call this method before inserting each emp object in employee table
	public void beforeEmpInsert(Employee e) {
		System.out.println("Before Employee Insert");
		System.out.println("Raise Laptop Request for "+e.getName());
		
	}
	
	@PostPersist //call this method after inserting each emp in employee table
	public void afterEmpInsert(Employee e){
		System.out.println("After Employee Insert");
		System.out.println("Screen name generated: "+e.getName()+e.getEmpno());
	}
	
	@PreUpdate // call this method before updating
	public void beforeUpdate (Employee e) {
		System.out.println("Before Update: "+e);
	}
	
	@PostUpdate //call this method after updating
	public void afterUpdate(Employee e) {
		System.out.println("After Update: "+e);
	}
	
	@PostLoad // call this after loading each emp object in employee table
	public void afterLoading(Employee e) {
		System.out.println("Employee Fetched: "+e);
	}
	
	@PreRemove //call this method before removing each emp object in employee table
	public void beforeDelete( Employee e) {
		System.out.println("Before Removing "+e);
		System.out.println("Disable Profile for "+e.getEmpno());
	}

}
