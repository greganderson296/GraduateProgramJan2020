package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marking the class as bean to be created
@Scope("singleton") // singleton: One object used across test cases, prototype: one object per request

public class DepartmentService {
	
String exampleProperty;
	
	public DepartmentService() {
		System.out.println("Department Service Created");
	}
	
	@PostConstruct // initialization method of the class
	public void initalizeService() {
		System.out.println("Department Service Initialized");
		
	}
	
	@PreDestroy //calls before shutting down the application
	public void terminatesService() {
		System.out.println("Department Service Terminated");
	}
	
	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring Example Data Source")
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set :"+exampleProperty);
		this.exampleProperty = exampleProperty;
	}

	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}

}
