package com.example.graphical.Models;

public class FoodItem{
	private String name;
	private double price;
	private int pricePoint;
	
	public FoodItem(String name, Double price, int pricePoint){
		this.name = name;
		if(price != null)
		this.price = price;
		else
			this.price=-1;
		this.pricePoint = pricePoint;
	}
}
