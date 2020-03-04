package com.mastek.Bank.api;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.Bank.services.BankServices;



@Component
public class APIConfig extends ResourceConfig{
	
	public APIConfig() { 
		

	register (BankServices.class);
	register(CORSFilter.class);
}
}