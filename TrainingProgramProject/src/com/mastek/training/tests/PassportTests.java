package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.mastek.training.passport.DataAccessObjectPassport;
import com.mastek.training.passport.Passport;
import com.mastek.training.passport.PassportJDBCDAO;

class PassportTests {
	
	DataAccessObjectPassport<Passport> pasDAO;

	@BeforeEach
	void setUp() throws Exception {
		pasDAO = new PassportJDBCDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	void testAddPassportData() {
		Passport newPas = new Passport();
		newPas.setPasno(333);
		newPas.setFirstName("Steve");
		newPas.setLastName("Bond");
		newPas.setExpiry(1966);
		
		
		
		
		newPas = pasDAO.add(newPas); 
		assertNull(newPas,"Passort Not Added");
		
		
		
//		System.out.println("Passport Number: "+newPas.getPasno()
//		+(" First Name: "+newPas.getFirstName())
//		+(" Last Name: "+newPas.getLastName())
//		+(" Expiry: "+newPas.getExpiry()));
		
				
		
	}
	

}
