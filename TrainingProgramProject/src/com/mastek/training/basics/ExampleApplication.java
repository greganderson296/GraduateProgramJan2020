package com.mastek.training.basics;

public class ExampleApplication {

		public static void main(String[] args) {
			int maxResult=0;
			String divResult=" ";
			double milesResult=0;
			String areaResult=" ";	
			int minimumNumber = 0;
			
			
			maxResult = SolutionProvider.getMaxNumber(10, 2);
					System.out.println("Max Result is " + maxResult);
					
				

			divResult = SolutionProvider.divideNumber(11,3);
			System.out.println("The Quotient and Remainder is " + divResult);
			
			
			
			milesResult = SolutionProvider.kilosToMiles(11);
			System.out.println("The distance in Miles is " + milesResult);


			areaResult = SolutionProvider.area(11,11,12);
			System.out.println("The area of the square and rectangle are " + areaResult + " respectively");


		SolutionProvider.multiplicationTable(4);

		
			minimumNumber = SolutionProvider.minNumber(11,10,9);
			System.out.println("The minimum number is " + minimumNumber);
}
}


