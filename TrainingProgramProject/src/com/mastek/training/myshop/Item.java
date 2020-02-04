package com.mastek.training.myshop;

public class Item
	implements Comparable<Item> // it provides the default sorting for tree set
{
	
	private int itemId;
	private String itemName;
	private int itemQuantity;
	private double unitPrice;
	
	
	public Item() {
		
	}
	public Item(int itemId, String itemName, double unitPrice, int itemQuantity) {
		setItemId(itemId);
		setItemName(itemName);
		setUnitPrice(unitPrice);
		
	}
	
	public Item(int itemId) {
		setItemId(itemId);
	}
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", unitPrice="
				+ unitPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	
	}
	
	//Treeset uses compareTo for default order
	@Override
	public int compareTo(Item anotherItem) {
		// return a number
		// if positive then current object is greater than anotherItem, zero if equal 
		// negative if less than anotherItem
		//System.out.println("comparing items");
		return this.getItemId() - anotherItem.getItemId();
		// we all need to compare the unique/key values for managing order
	}
	
	

}
