package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;



class HRApplicationTests {
	
	Employee ex1;
	
	
	@BeforeEach
	public void setupEmpTestCases() {
		System.out.println("Before Test Case");
		// Employee.DEFAULT_ZERO; // <class_name>.<static_member>
		ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.Manager);
		ex1.setGrade(Grades.G8);	
		
		Employee ex2 = new Employee(1122);
		Employee ex3 = new Employee(2233, "Example",334.0,Designations.Developer);
		
		ex2 = null; //release the object for garbage collection
		ex3 = null;
		System.gc(); // notify system to collect garbage
		
		// ex2.getEmpno(); will throw NullPointerException
	}
	
	@AfterEach
	public void tearDownEmpTestCases(){
		System.out.println("After Test Case");
	}
	
	
	@Test
	void testCreateEmployeeObject() {
		System.out.println("Test Case Create");
		
		
		System.out.println(
				" Number: "+ex1.getEmpno()+
				" \n Name: "+ex1.getName()+
				" \n Day Salary "+ex1.getUnitDaySalary()+
				" \n Designation: "+ex1.getDesignation()+
				" \n Grade: "+ex1.getGrade());
		
	}
	
	@Test
	void testCreateAndComputeSalaryEmployeeObject() {
		System.out.println("Test Case Compute");
		/*Employee ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.Manager);
		ex1.setGrade(Grades.G8);*/	
		
		try {
			assertEquals(9000.0, ex1.getNetSalary(30),"invalid Net Salary Computation");
			assertEquals(0, ex1.getNetSalary(-30),"invalid Net Salary Computation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@Test
void testSalesEmployeeObjectUsage(){
SalesEmployee saleEx1 = new SalesEmployee();
saleEx1.setEmpno(224);
saleEx1.setName("example");
saleEx1.setUnitDaySalary(100);
saleEx1.setDesignation(Designations.Officer);
saleEx1.setGrade(Grades.G8);
saleEx1.setComission(0.8);
saleEx1.setTarget(1000000000);

try {
assertEquals(1620,saleEx1.getNetSalary(9),"Invalid Salary Calculated");
}catch(Exception e) {
	e.printStackTrace();
}



}
@Test
void testObjectFeaturesOnEmployee() {
	System.out.println("Object Features Start");
	System.out.println(ex1);
	System.out.println("haseCode: "+ex1.hashCode());
	
	System.out.println("Object Features End");
}

@Test
void testSendAnnouncementToEMployees() {
	// we can not create an object of abstract class using new key word
	//Announcement exAnnouncement = new Announcement();
	
	//to use an abstract class object, you must extend it with derived class
	// and override ALL abstract methods defined in base/Parent class
	Announcement exSMS = new SMSAnnouncement();
	exSMS.setFrom("UK-HR");
	exSMS.setForGroup("MASTEKEER_AT_GLASGOW");
	exSMS.setSubject("Inclement Weather Conditions in Glasgow");
	exSMS.setContentText("All EMployees are advised to work from home, tomorrow");
	
	Announcement exEmail = new EmailAnnouncement();
	exEmail.setFrom("Leadership Team");
	exEmail.setForGroup("MASTEKEERs");
	exEmail.setSubject("Q Meet Jan 2020");
	exEmail.setContentText("You are all invited to attend Quaterly Meet Online via Webex");
	
	if(exSMS instanceof SMSAnnouncement) {
		System.out.println("COnnect to Telecom SMS Service");
		exSMS.sendAnnouncement(); // connect to SMS and use send from SMSAnnouncement
		}
	
	if(exEmail instanceof EmailAnnouncement) {
		System.out.println("COnnect to Email Service");
		exEmail.sendAnnouncement();// connect to Email and use send from SMSAnnouncement
	}
	
	assertTrue(exSMS instanceof SMSAnnouncement, "Invalid Announcement Implementation");
	assertTrue(exEmail instanceof EmailAnnouncement, "Invalid Announcement Implementation");
}
	@Test
	void testShapeExample() {
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle(); 
		circle.setRadius(20);
			
		Shape shRect = rect;
		Shape shCircle = circle;

		System.out.println("Rectangle Area: "+shRect.getArea());
		System.out.println("Rectangle Perimeter: "+shRect.getPerimeter());
		
		System.out.println("Circle Area: "+shCircle.getArea());
		System.out.println("Circle Perimeter: "+shCircle.getPerimeter());
		
	assertTrue(rect instanceof Shape, "Invalid Type of Shape");
	assertTrue(circle instanceof Shape, "Invalid Type of Shape");
	}
}
