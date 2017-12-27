package com.neeraj.views;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.neeraj.item.Item;
import com.neeraj.item.ItemOperations;

public class MyModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5532688006857946576L;
	private String colNames[] = {"Id","Name","Price","Quantity"}; 
	public int getRowCount() {
		ItemOperations io = ItemOperations.getInstance();
		int size = io.getList().size();
		return size;
	}
	public int  getColumnCount() {
		return 4;
	}
	
	public String getValueAt(int r, int c) {
		ItemOperations io = ItemOperations.getInstance();
		ArrayList<Item> ar = io.getList();
		Item i = ar.get(r);
		switch(c){
		case 0: return ""+i.getId();
		case 1: return i.getName();
		case 2: return ""+i.getPrice();
		case 3: return ""+i.getQty();
		default : return null;
		}
	}
	
	public String getColumnName(int c) {
		return colNames[c];
	}

}
