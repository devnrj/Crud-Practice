package com.neeraj.item;

import java.util.ArrayList;
import java.util.Collections;

public class ItemOperations {
	private ArrayList<Item> itemList;
	private static ItemOperations io;
	private ItemOperations() {
		itemList = new ArrayList<>();
	}
	
	public static ItemOperations getInstance() {
		synchronized(ItemOperations.class){
			if(io==null) {
				io = new ItemOperations();
			}
		}
		
		return io;
	}
	
	public String addItem(Item item) {
		itemList.add(item);
		return "Item Added";
	}
	public int searchItem(int id, String name) {
		Item i = new Item();
		i.setId(id);
		i.setName(name);
		return itemList.indexOf(i);
	}
	
	public void sortItem() {
		Collections.sort(itemList,new SortByName());
		
	}
	public String deleteItem(int id, String name) {
		int i=this.searchItem(id,name);
		if(i<0) {
			return "Item Does Not Exist";
		}            
		itemList.remove(i);
		return "Item Removed at"+i;
	}
	public ArrayList<Item> getList(){
		return itemList;
	}
	
}
