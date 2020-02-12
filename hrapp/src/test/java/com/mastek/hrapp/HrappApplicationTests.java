package com.mastek.hrapp;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPosition;
import com.mastek.hrapp.entities.Payment;
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
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	JobPositionDAO jobDAO;
	
	@Test
	void testApplyForJobPosition() {
		int jobId=122;
		int empno=16;
		JobPosition jp = empSvc.applyForJobPosition(122, 16);
		assertNotNull(jp, "Job not Applied");
		for (Employee applicant : jp.getApplicants()) {
			System.out.println(applicant);
			
		}
	}
	
	//@Test
	void testAddJobPositionDocument() {
		JobPosition jp = new JobPosition();
		jp.setJobId(122);
		jp.setLocation("Leeds");
		jp.setClientName("NHS");
		jp.setSkillsRequired("Java");
		jp.setNumberofPositions(3);
		
		jp = jobDAO.save(jp);
		
		assertNotNull(jp,"Job Position Not Saved");
		
		
	}
	
	@Test
	void TestListAllJobPositions(){
		System.out.println("Print All Job Positions");
		for (JobPosition jp : jobDAO.findAll()) {
			System.out.println(jp);	}
	}
	//@Test
	void testCashPaymentAdd() {
		Payment cashP = new Payment();
		cashP.setAmount(200);
		
		cashP= paymentDAO.save(cashP);
		
		System.out.println(cashP);
		assertNotNull(cashP, "Cash Paymeny Not Saved");
		
		
		
	}
	
	//@Test
	void testChequePaymentAdd() {
		ChequePayment cheqP = new ChequePayment();
		cheqP.setAmount(777);
		cheqP.setChequeNumber(65656565);
		cheqP.setBankName("RBS");
		
		cheqP= paymentDAO.save(cheqP);
		
		System.out.println(cheqP);
		assertNotNull(cheqP, "Cheque Paymeny Not Saved");
		
		
		
	}
	
	//@Test
	void testCardPaymentAdd() {
		CardPayment cardP = new CardPayment();
		cardP.setAmount(666);
		cardP.setCardNumber(89898989);
		cardP.setCardService("VISA");
		
		cardP= paymentDAO.save(cardP);
		
		System.out.println(cardP);
		assertNotNull(cardP, "Card Payment Not Saved");
		
		
		
	}
	
	@Test
	void testFindEmployeeBySalary() {
		int minSalary=100;
		int maxSalary=5000;
		Iterable<Employee> emps = empDAO.findBySalary(minSalary, maxSalary);
		System.out.println("All Employees having Salary between min: "+minSalary+" and max: "+maxSalary);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		
	}
	
	@Test
	void testFindEmployeeByDesignation() {
		Iterable<Employee> emps  = empDAO.findByDesignation(Designation.MANAGER);
		
		System.out.println("All Employees with Designation as "+Designation.MANAGER);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		
	}
	
	

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
	
	@Test
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
	
	@Test
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
		//@Test
		void testAssignEmployeeToDepartment() {
			Employee emp = empSvc.assignEmployeeToDepartment(1,11);
			assertNotNull(emp.getCurrentDepartment(),"Department not Assigned");
		
	}
		
		//@Test
		void testAssignEmployeeToProject() {
			Employee emp = empSvc.assignEmployeeToProject(1, 12);
			assertTrue(emp.getProjectsAssigned().size()>0,"Projects Assigned");
		
		}
		
		
}
