package com.frank.generic;

public class Test {
	
	public static void main(String[] args) {
		
		Plate<? super Fruit> plate = new Plate(new Apple());
		
		plate.setPlate(new Fruit());
		
//		Apple apple = plate.getPlate();
		
//		Fruit fruit = plate.getPlate();
		
		
	}

}
