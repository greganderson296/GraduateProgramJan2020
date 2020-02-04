package com.mastek.training.basics;

public class SolutionProvider {
	
	/*
	 * take two numbers from the user and display the maximum number as output
	 */
	// public static <return-datatype> <name>(<param_type1><param_name1>,........)
	public static int getMaxNumber(int num1, int num2) {
		int max=0; // declare output as local variable 
		if (num1>num2) { //validate the conditions for logical result
			max=num1;
		}else {
				max=num2;
			}
			
		return max;//return the result to the caller
	}
	
	public static String divideNumber(int num1, int num2) {
		
		int quotient=num1/num2;
		int remainder=num1%num2;		
		String answer= quotient +","+remainder;	
		
	return answer;
	}
	
	public static double kilosToMiles(int num1) {
		
		double miles=num1/1.6;	
			
		
	return miles;
	}
	
	public static String area(int sl, int rl, int rw) {
		
		double square=sl*sl;
		double rectangle=rl*rw;
		String areas = square +" and "+ rectangle;	
		
	return areas ;
	}

	
	public static void multiplicationTable (int num1) {
		
		for (int i=1; i<11; i++) {
			System.out.println(i*num1);
		}
	
	}
	
	public static int minNumber (int num1, int num2, int num3) {
	int min1=0; int min=0;
	if (num1<num2) {min1=num1;}
	else {min1=num2;};
	
	if (min1<num3) {min=min1;}
	else {min=num3;};
	
	return min;
		
	}

}
