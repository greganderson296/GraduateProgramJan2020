package com.mastek.training.packone;

import java.util.Scanner;

public class ExceptionExample {
	
	public static void main (String[] args) {
		
		int num1=0,num2=0,result=0;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Num1");
			num1 = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Num2");
			num2 = Integer.parseInt(sc.nextLine());
			
			result = num1/num2;
			System.out.println("Division is: "+result);
		} catch (NumberFormatException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace(); //print the exception information on the console
			System.err.println("Invalid Number Entered");
		}
		catch(Exception ex) { //handles all types of exceptions
			System.err.println("Exception Occured: "+ex);
			System.err.println("Exception Message: "+ex.getMessage()); // print the exception
			//with message 
			ex.printStackTrace(); //print the complete information about the exception :: Stack trace
		}
		finally { System.out.println("Scanner CLosed"); //block will be executed in all the 
		//the scenarios of success or failure of application. In case the exception is not
		//handled , it will abort the application after the finally block.
		sc.close();
		}
		// represents the rest of the code
		System.out.println("Program Completed");
	}

}
