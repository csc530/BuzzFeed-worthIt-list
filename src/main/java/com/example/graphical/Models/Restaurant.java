package com.example.graphical.Models;

import java.util.ArrayList;

public class Restaurant{
	private String name, notes, country, city,episodeName, season;
	private int id, episode;
	private ArrayList<FoodItem> foodItems;
	
	public Restaurant(String season, int episode, String episodeName, String name,String city,String country, String notes){
		this.name = name;
		this.notes = notes;
		this.country = country;
		this.city = city;
		this.episodeName = episodeName;
		this.season = season;
		this.episode = episode;
		foodItems = new ArrayList<FoodItem>();
 	}
	
	public String getName(){
		return name;
	}
	
	public String getNotes(){
		return notes;
	}
	
	public String getCountry(){
		return country;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getEpisodeName(){
		return episodeName;
	}
	
	public String getSeason(){
		return season;
	}
	
	public int getId(){
		return id;
	}
	
	public int getEpisode(){
		return episode;
	}
	
	public ArrayList<FoodItem> getFoodItems(){
		return foodItems;
	}
	
	public void addItem(FoodItem item){
		foodItems.add(item);
	}
	
	public void addItem(ArrayList<FoodItem> item){
		foodItems.addAll(item);
	}
}
