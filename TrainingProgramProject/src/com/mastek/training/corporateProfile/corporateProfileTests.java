package com.mastek.training.corporateProfile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class corporateProfileTests {
	profile ex1;
	
	
	@BeforeEach
	public void setupProfileTestCases() {
		System.out.println("Before Test Case");
		ex1 = new profile();
		ex1.setName("John");
		ex1.setCertification("BSc");
		ex1.setQualification("Computer Science");
		ex1.setJobDetails("Graduate");
		
	}

	@Test
	void testCreateProfileObject() {
		System.out.println("Test Case Create");
		
		
		System.out.println(
				
				" \n Name: "+ex1.getName()+
				" \n Qualification "+ex1.getQualification()+
				" \n Certification: "+ex1.getCertification()+
				" \n Job Details: "+ex1.getJobDetails());
	}
	
	

}
