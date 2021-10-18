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
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public int getPricePoint(){
		return pricePoint;
	}
	
	public void setPricePoint(int pricePoint){
		this.pricePoint = pricePoint;
	}
}
