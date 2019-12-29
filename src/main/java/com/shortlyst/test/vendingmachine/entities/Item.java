package com.shortlyst.test.vendingmachine.entities;

/*
 * An item is a purchasable good from the vending machine, having a name and price
 */
public class Item {

	private int price;
	private String name;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
		this.name = name;
	}
	
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        assert (0 < price);
        this.price = price;
    }
}
