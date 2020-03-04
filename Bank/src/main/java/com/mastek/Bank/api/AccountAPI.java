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
import com.mastek.Bank.entities.Transaction;

@Path("/Bank/")
public interface AccountAPI {

	@GET
	@Path("/accounts/list")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Account>listAllAccounts();
	
	@GET
	@Path("/accounts/find/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Account findByAccountId(@PathParam("accountId")int accountId);
	
	@POST //http method Post used to send data in requests
	@Path("/account/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Account registerNewAccount(@BeanParam Account newAccount);
	
	@GET
	@Path("/customer/transactions/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Transaction> getAccountTransactions(@PathParam("accountId") int accountId);
	
	@POST
	@Path("/customer/transactions/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction registerTransactionForAccount(
			@FormParam("accountId") int accountId, 
			@BeanParam Transaction newTransaction);
}
