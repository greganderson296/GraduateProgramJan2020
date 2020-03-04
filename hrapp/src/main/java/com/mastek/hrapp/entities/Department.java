package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity //declares the class as Entity, to be managed by JPA
@Table(name="JPA_Departments") //declare the table name associated with this class

public class Department {
	
	int depno;
	
	@FormParam("name")
	String name;
	
	@FormParam("location")
	String location;
	
	
	// specify in mappedBy the 'joinColumn config property name
	Set<Employee> team = new HashSet<>();
	//associates the many entity using collection with cascade enabled
	
	@OneToMany(mappedBy="currentDepartment",cascade=CascadeType.ALL)
	@XmlTransient
	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}

	
	
	
	
	public Department() { 
		
	}
	
	@Id //marking the property as primary Key for the table
	@Column(name="department_number")//using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)//Auto numbering configuration as per DB
	
	public int getDepno() {
		return depno;
	}

	public void setDepno(int depno) {
		this.depno = depno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + depno;
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
		Department other = (Department) obj;
		if (depno != other.depno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [depno=" + depno + ", name=" + name + ", location=" + location + "]";
	}




	
	
	
}
//@Transient: to mark: the property get method, not to be stored in DB table


