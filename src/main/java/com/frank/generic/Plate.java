package com.frank.generic;

public class Plate<T> {
	
	private T t;
	
	public  Plate(T t){
		this.t = t;
	}
	
	public void setPlate(T t){
		this.t = t;
	}
	
	public T getPlate(){
		
		return t;
	}

}
