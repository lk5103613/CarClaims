package com.taoqibao.entity;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer customer1, Customer customer2) {
		if (customer1.sortModel.getSortLetters().equals("@")
				|| customer2.sortModel.getSortLetters().equals("#")) {
			return -1;
		} else if (customer1.sortModel.getSortLetters().equals("#")
				|| customer2.sortModel.getSortLetters().equals("@")) {
			return 1;
		} else {
			return customer1.sortModel.getSortLetters().compareTo(customer2.sortModel.getSortLetters());
		}
	}
	
	

}
