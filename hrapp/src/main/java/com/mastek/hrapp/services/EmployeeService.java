package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPosition;
import com.mastek.hrapp.entities.Project;

@Component //marking the class as bean to be created
@Scope("singleton") // singleton: One object used across test cases, prototype: one object per request

public class EmployeeService implements EmployeeAPI{
	
	String exampleProperty;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO depDAO;
	
	@Autowired
	ProjectJPADAO proDAO;
	
	@Autowired
	JobPositionDAO jobsDAO;
	
	
	
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	@PostConstruct // initialization method of the class
	public void initalizeService() {
		System.out.println("Employee Service Initialized");
		
	}
	
	@PreDestroy //calls before shutting down the application
	public void terminatesService() {
		System.out.println("Employee Service Terminated");
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
	@Transactional //this will keep the session open until the method returns the value
	public Employee assignEmployeeToDepartment(int empno, int depno) {
		Employee emp = empDAO.findById(empno).get(); //fetch the employee if it exists
		Department dep = depDAO.findById(depno).get(); //fetch the department if it exists
		
		emp.setCurrentDepartment(dep);//assign the department to employee
		dep.getTeam().add(emp); //assign the Employee in the department team
		
		empDAO.save(emp); //save changes in database
		depDAO.save(dep);
		
		return emp;
	}
@Transactional
	public Employee assignEmployeeToProject(int empno, int projectId) {
		Employee emp = empDAO.findById(empno).get(); //get employee object
		Project newProject = proDAO.findById(projectId).get(); //get the project object
		
		emp.getProjectsAssigned().add(newProject); //assign employee to project
		empDAO.save(emp); //save employee object
		return emp; //return the employee object
	}
	@Transactional
	public JobPosition applyForJobPosition(int jobId, int empno) {
		JobPosition job = jobsDAO.findById(jobId).get();
		Employee emp = empDAO.findById(empno).get();
		//adding employee object in applicants collection
		job.getApplicants().add(emp);
		
		job = jobsDAO.save(job);
		return job;
	
	
}

	@Override
	public Iterable<Employee> listAllEmployees() {
		System.out.println("Listing all EMployees");
		return empDAO.findAll();	}

	@Override
	public Employee findByEmpno(int empno) {
		return empDAO.findById(empno).get();
	}

	@Override
	public Employee registerNewEmployee(Employee newEmployee) {
		newEmployee = empDAO.save(newEmployee);
		return newEmployee;
	}

}
