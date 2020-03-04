package com.mastek.Bank.api;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.Bank.entities.Account;
import com.mastek.Bank.entities.Customer;



@Path("/Bank/")
public interface CustomerAPI {
	
	@GET
	@Path("/customers/list")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Customer>listAllCustomers();
	
	@GET
	@Path("/customer/find/{custId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Customer findByCustomerId(@PathParam("custId")int custId);
	
	@POST //http method Post used to send data in requests
	@Path("/customer/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer registerNewCustomer(@BeanParam Customer newCust);
	
	@GET
	@Path("/customer/accounts/{custId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Account> getCustomerAccounts(@PathParam("custId") int custId);
	
	@POST
	@Path("/customer/accounts/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Account registerAccountForCustomer(
			@FormParam("custId") int custId, 
			@BeanParam Account newAccount);

}
