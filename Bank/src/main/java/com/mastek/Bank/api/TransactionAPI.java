package com.mastek.Bank.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.Bank.entities.Transaction;


@Path("/Bank/")
public interface TransactionAPI {
	
	@GET
	@Path("/transactions/list")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Transaction>listAllTransactions();
	
	@GET
	@Path("/transactions/find/{transactionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Transaction findByTransactionId(@PathParam("transactionId")int transactionId);
	
	@POST //http method Post used to send data in requests
	@Path("/transaction/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction registerNewTransaction(@BeanParam Transaction newTransaction);

}
