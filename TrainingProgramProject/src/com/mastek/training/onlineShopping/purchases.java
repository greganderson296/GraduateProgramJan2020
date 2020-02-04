package com.mastek.training.onlineShopping;
import com.mastek.training.onlineShopping.shoppingCart;

public class purchases {
	
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

}
