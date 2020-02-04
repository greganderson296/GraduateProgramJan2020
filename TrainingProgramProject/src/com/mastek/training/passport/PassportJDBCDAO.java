package com.mastek.training.passport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;




public class PassportJDBCDAO implements DataAccessObjectPassport<Passport> {
	
	Connection conMysql;
	
	public PassportJDBCDAO() {
		try {
			//1. Load the database Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Open the connection to MYSQL
		conMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_2020_masteknet",
				"root", //username)
				"root"); //password
		System.out.println("Connection Successful");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Passport add(Passport newPassport) {
		//1. Define the query inSQL 
		String sqlInsert = "Insert into jdbc_passports "
				+"(passport_no, first_name, last_name, expiry) "
				+" values(?,?,?,?)";
		//2. Prepare the statement object for the query
		try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)){
			//3. set all the parameters required in the query
			psInsert.setInt(1,  newPassport.getPasno());
			psInsert.setString(2,  newPassport.getFirstName());
			psInsert.setString(3, newPassport.getLastName());
			psInsert.setInt(4, newPassport.getExpiry());
			
			
			//4. execute the query on the database table return the rows affected
			int recordsAffected = psInsert.executeUpdate();
			System.out.println(recordsAffected+ "Passport Inserted");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
		
		
		
	

			

}
