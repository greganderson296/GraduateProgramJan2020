package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.onlineShopping.shoppingCart;



class onlineShoppingTests {

	
shoppingCart ex1;
	
	
public double total_cost= ex1.getMilk()+ ex1.getCheese()+ ex1.getBread()+ ex1.getButter()+ 
ex1.getChicken()+ ex1.getKetchup()+ ex1.getWater()+ ex1.getShirt()+ 
ex1.getChocolate()+ ex1.getSweets()+ 
ex1.getIce() ;

public double total_items = ex1.getMilk()/ex1.MILK_PRICE+ ex1.getCheese()/ex1.CHEESE_PRICE+ 
ex1.getBread()/ex1.BREAD_PRICE+ ex1.getButter()/ex1.BUTTER_PRICE+ 
ex1.getChicken()/ex1.CHICKEN_PRICE+ ex1.getKetchup()/ex1.KETCHUP_PRICE+ 
ex1.getWater()/ex1.WATER_PRICE+ ex1.getShirt()/ex1.SHIRT_PRICE+ 
ex1.getChocolate()/ex1.CHOCOLATE_PRICE+ ex1.getSweets()/ex1.SWEETS_PRICE+ 
ex1.getIce()/ex1.ICE_PRICE ;	


@BeforeEach
	public void setupShoppingCartTestCases() {
		System.out.println("Before Test Case");
		ex1 = new shoppingCart();
		ex1.setMilk(2);
		ex1.setCheese(1);
		ex1.setBread(0);
		ex1.setButter(1);
		ex1.setChicken(1);
		ex1.setKetchup(0);
		ex1.setWater(1);
		ex1.setShirt(1);
		ex1.setChocolate(0);
		ex1.setSweets(1);
		ex1.setIce(1);
		
	}
	
 
	
		
		@Test
		void testCreateShoppingCartObject() {
			System.out.println("Test Case Create");
			
	
		if (ex1.total_items<11) {	
		System.out.println(
					" Milk: "+ex1.getMilk()+
					" \n Cheese: "+ex1.getCheese()+
					" \n Bread "+ex1.getBread()+
					" \n Butter: "+ex1.getButter()+
					" \n Chicken: "+ex1.getChicken()+
					" \n Ketchup: "+ex1.getKetchup()+
					" \n Water: "+ex1.getWater()+
					" \n Shirt: "+ex1.getShirt()+
					" \n Chocolate: "+ex1.getChocolate()+
					" \n Sweets: "+ex1.getSweets()+
					" \n Ice: "+ex1.getIce()+
					" \n Total Cost is "+ ex1.total_cost+
					"\n Total Item Count is: "+ex1.total_items);
			
		}
		else {System.out.println("Max number of items exceeded");}
			
			
			/*Scanner discCode = new Scanner(System.in);
			System.out.println("Enter Discount Code......");
			 String discountCode = discCode.nextLine();
			 
			 if (discountCode== "Black") {total_cost= total_cost*0.5};
			 else {};
			 
			 System.out.println("Black Discount Applied");*/
			
		}
		}



