package com.neeraj.item;
import java.util.Comparator;

public class SortByName implements Comparator<Item>{
	public int compare(Item first,Item second) {
		return first.getName().compareTo(second.getName());
	}
	

}
