package com.taoqibao.entity;

import java.util.Comparator;

public class CarBrandComparator implements Comparator<CarBrand> {

	@Override
	public int compare(CarBrand carBrand1, CarBrand carBrand2) {
		if (carBrand1.sortModel.getSortLetters().equals("@")
				|| carBrand2.sortModel.getSortLetters().equals("#")) {
			return -1;
		} else if (carBrand1.sortModel.getSortLetters().equals("#")
				|| carBrand2.sortModel.getSortLetters().equals("@")) {
			return 1;
		} else {
			return carBrand1.sortModel.getSortLetters().compareTo(carBrand2.sortModel.getSortLetters());
		}
	}


}
