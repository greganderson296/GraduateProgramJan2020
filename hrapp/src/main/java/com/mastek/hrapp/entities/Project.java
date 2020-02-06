package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity //declares the class as Entity, to be managed by JPA
@Table(name="JPA_Projects") //declare the table name associated with this class
public class Project {
	
	int prono;
	String name;
	String customerName;
	
	Set<Employee> projectTeam= new HashSet<>();
	
	
	@ManyToMany(mappedBy="projectsAssigned") //Provide the property in employee with @ManyToMany and @JoinTable configuration
	public Set<Employee> getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(Set<Employee> projectTeam) {
		this.projectTeam = projectTeam;
	}

	public Project() { 
		
	}
	
	@Id //marking the property as primary Key for the table
	@Column(name="project_number")//using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)//Auto numbering configuration as per DB
	public int getProno() {
		return prono;
	}

	public void setProno(int prono) {
		this.prono = prono;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + prono;
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
		Project other = (Project) obj;
		if (prono != other.prono)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [prono=" + prono + ", name=" + name + ", customerName=" + customerName + "]";
	}
	
	

}
