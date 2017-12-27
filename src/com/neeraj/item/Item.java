package com.neeraj.item;

public class Item implements Comparable<Item>{
	private int id;
	private String name;
	private double price;
	private int qty;
	public Item(int id, String name, double price, int qty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	public Item() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item item = (Item)obj;
			if(item.id==this.id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
	@Override
	public int compareTo(Item second) {
		return ((Double)this.price).compareTo(second.price);
	}
	
}
