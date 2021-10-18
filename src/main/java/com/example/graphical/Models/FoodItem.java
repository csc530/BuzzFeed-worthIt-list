package com.example.graphical.Models;

public class FoodItem{
	private String name;
	private double price;
	private int pricePoint;
	
	public FoodItem(String name, double price, int pricePoint){
		setName(name);
		setPrice(price);
		setPricePoint(pricePoint);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		if(name.isEmpty() || name.isBlank() || name.length() < 3)
			throw new IllegalArgumentException("The food must have a name at least 3 characters long.");
		this.name = name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		if(price < 0.01)
			throw new IllegalArgumentException("The food price must be at least 1¢.");
		this.price = price;
	}
	
	public int getPricePoint(){
		return pricePoint;
	}
	
	public void setPricePoint(int pricePoint){
		if(pricePoint < 1)
			throw new IllegalArgumentException("The food price point must be at least 1");
		this.pricePoint = pricePoint;
	}
}
