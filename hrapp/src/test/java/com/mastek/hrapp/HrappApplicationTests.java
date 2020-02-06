package com.mastek.hrapp;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.DepartmentService;
import com.mastek.hrapp.services.EmployeeService;
import com.mastek.hrapp.services.ProjectService;

@SpringBootTest
class HrappApplicationTests {
	
	
	@Autowired //spring will provide the object using IOC, dependency Injection technique
	EmployeeService empSvc;
	
	@Autowired
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
//	@Autowired //spring will provide the object using IOC, dependency Injection technique
//	DepartmentService depSvc;
//	
//	@Autowired
//	DepartmentService depSvc1;
	
	@Autowired
	DepartmentJPADAO depDAO;
	
//	@Autowired //spring will provide the object using IOC, dependency Injection technique
//	ProjectService proSvc;
//	
//	@Autowired
//	ProjectService proSvc1;
	
	@Autowired
	ProjectJPADAO proDAO;
	
	

	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
		
	}
	
	//@Test
	void testEmployeeDAOadd() {
		Employee emp = new Employee();
		emp.setName("Peter");
		emp.setSalary(80);
		emp.setDesignation(Designation.MANAGER);
		
		emp = empDAO.save(emp);
		System.out.println(emp);
		assertNotNull(emp, "Employee Not Added");
		
	}
	
	@Test
	void testListEmployees() {
		Iterable<Employee>emps = empDAO.findAll();
		assertNotNull(emps, "Employees Not Found");
		for(Employee employee : emps) {
			System.out.println(employee);
		}
		}
	
	//@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee Fetched: "+emp);
		
		emp.setSalary(emp.getSalary()+1002);
		emp.setDesignation(Designation.TESTER);
		emp = empDAO.save(emp);
		System.out.println("Updated Employee: "+emp);
	}
	
	//@Test
	void testDeleteEmployeeById() {
		// empDAO.delete(emp); //deletes by object
		 empDAO.deleteById(23); // deletes ID
	}
		
//		@Test
//		void testDepartmentServiceExampleMethod() {
//			depSvc.exampleMethod();
//			depSvc1.exampleMethod();
//	}
	
	//@Test
	void testDepartmentDAOadd() {
		Department dep = new Department();
		dep.setName("admin");
		dep.setLocation("Madrid");
		
		
		dep = depDAO.save(dep);
		System.out.println(dep);
		assertNotNull(dep, "Department Not Added");
		
	}
	
	@Test
	void testListDepartments() {
		Iterable<Department> deps = depDAO.findAll();
		assertNotNull(deps, "Departments Not Found");
		for(Department department : deps) {
			System.out.println(department);
		}
	}
	
//	@Test
//	void testProjectServiceExampleMethod() {
//		proSvc.exampleMethod();
//		proSvc1.exampleMethod();
//		
//	}
	
	//@Test
	void testProjectDAOadd() {
		Project pro = new Project();
		pro.setName("New Project");
		pro.setCustomerName("NHS");
		
		
		pro = proDAO.save(pro);
		System.out.println(pro);
		assertNotNull(pro, "Project Not Added");
		
	}
	
	@Test
	void testListProjects() {
		Iterable<Project>pros = proDAO.findAll();
		assertNotNull(pros, "Projects Not Found");
		for(Project project : pros) {
			System.out.println(project);
		}
	}
		@Test
		void testAssignEmployeeToDepartment() {
			Employee emp = empSvc.assignEmployeeToDepartment(1,11);
			assertNotNull(emp.getCurrentDepartment(),"Department not Assigned");
		
	}
		
		@Test
		void testAssignEmployeeToProject() {
			Employee emp = empSvc.assignEmployeeToProject(1, 12);
			assertTrue(emp.getProjectsAssigned().size()>0,"Projects Assigned");
		
		}
}
