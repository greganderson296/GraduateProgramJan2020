package com.mastek.training.onlineShopping;

public class shoppingCart {

	public static final int MILK_PRICE=1;
	public static final int CHEESE_PRICE=2;
	public static final int BREAD_PRICE=3;
	public static final int BUTTER_PRICE=4;
	public static final int CHICKEN_PRICE=5;
	public static final int KETCHUP_PRICE=6;
	public static final int WATER_PRICE=7;
	public static final int SHIRT_PRICE=8;
	public static final int CHOCOLATE_PRICE=9;
	public static final int SWEETS_PRICE=10;
	public static final int ICE_PRICE=11;
	
	private int milk;
	private int cheese;
	private int bread;
	private int butter;
	private int chicken;
	private int ketchup;
	private int water;
	private int shirt;
	private int chocolate;
	private int sweets;
	private int ice;
	
	
	
	
	public int getMilk() {
		return milk * MILK_PRICE;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getCheese() {
		return cheese * CHEESE_PRICE;
	}
	public void setCheese(int cheese) {
		this.cheese = cheese;
	}
	public int getBread() {
		return bread * BREAD_PRICE;
	}
	public void setBread(int bread) {
		this.bread = bread;
	}
	public int getButter() {
		return butter * BUTTER_PRICE;
	}
	public void setButter(int butter) {
		this.butter = butter;
	}
	public int getChicken() {
		return chicken * CHICKEN_PRICE;
	}
	public void setChicken(int chicken) {
		this.chicken = chicken;
	}
	public int getKetchup() {
		return ketchup * KETCHUP_PRICE;
	}
	public void setKetchup(int ketchup) {
		this.ketchup = ketchup;
	}
	public int getWater() {
		return water * WATER_PRICE;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getShirt() {
		return shirt * SHIRT_PRICE;
	}
	public void setShirt(int shirt) {
		this.shirt = shirt;
	}
	public int getChocolate() {
		return chocolate * CHOCOLATE_PRICE;
	}
	public void setChocolate(int chocolate) {
		this.chocolate = chocolate;
	}
	public int getSweets() {
		return sweets * SWEETS_PRICE;
	}
	public void setSweets(int sweets) {
		this.sweets = sweets;
	}
	public int getIce() {
		return ice * ICE_PRICE;
	}
	public void setIce(int ice) {
		this.ice = ice;
	}
	
	public double total_cost= milk+ getCheese()+ getBread()+ getButter()+ 
			getChicken()+ getKetchup()+ getWater()+ getShirt()+ 
			getChocolate()+ getSweets()+ 
			getIce() ;
	
	public double total_items = getMilk()/MILK_PRICE+ getCheese()/CHEESE_PRICE+ 
			getBread()/BREAD_PRICE+ getButter()/BUTTER_PRICE+ 
			getChicken()/CHICKEN_PRICE+ getKetchup()/KETCHUP_PRICE+ 
			getWater()/WATER_PRICE+ getShirt()/SHIRT_PRICE+ 
			getChocolate()/CHOCOLATE_PRICE+ getSweets()/SWEETS_PRICE+ 
			getIce()/ICE_PRICE ; 
	
}
