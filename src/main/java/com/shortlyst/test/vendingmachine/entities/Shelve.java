package com.shortlyst.test.vendingmachine.entities;

/*
 * A shelve is the compartment of the machine, holding the items - It has an item and its quantity
 */
public class Shelve {

	private Item item;
	private int count;

	public Shelve(Item item, int count) {
		this.item = item;
		this.count = count;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/*
	 * 0 - Insufficient Money, 1 - Out of Stock, 2 - Available for Purchase
	 */
	public int getStatus(int insertedCoin) {

		// Out of Stock
		if (this.count == 0)
			return 1;

		// Available for purchase
		if (insertedCoin >= this.item.getPrice())
			return 2;

		// Insufficient Money
		return 0;
	}

	public String getStatusText(int insertedCoin) {

		if (this.count == 0)
			return "Out of Stock";

		// Available for purchase
		if (insertedCoin >= this.item.getPrice())
			return "Available for Purchase";

		// Insufficient Money
		return "";
	}
}
