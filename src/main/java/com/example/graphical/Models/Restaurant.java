package com.example.graphical.Models;

import java.util.ArrayList;

public class Restaurant{
	private String name, notes, country, city, episodeName, season;
	private int episode;
	private ArrayList<FoodItem> foodItems;
	
	public Restaurant(String name){
		setName(name);
		foodItems = new ArrayList<>();
	}
	
	public Restaurant(String name, String country){
		this(name);
		setCountry(country);
		foodItems = new ArrayList<>();
	}
	
	public Restaurant(String name, String city, String country){
		this(name, country);
		setCity(city);
		foodItems = new ArrayList<>();
	}
	
	public Restaurant(String name, String city, String country, String notes){
		this(name, country, city);
		setNotes(notes);
		foodItems = new ArrayList<>();
	}
	
	public Restaurant(String season, int episode, String episodeName, String name, String city, String country, String notes){
		this(name, city, country, notes);
		setEpisode(episode);
		setEpisodeName(episodeName);
		setSeason(season);
		foodItems = new ArrayList<>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		if(name.length() < 3)
			throw new IllegalArgumentException("Name must be at least 3 characters long.");
		this.name = name;
	}
	
	public String getNotes(){
		return notes;
	}
	
	public void setNotes(String notes){
		if(notes == null)
			throw new IllegalArgumentException("Notes cannot be null.");
		this.notes = notes;
	}
	
	public String getCountry(){
		return country;
	}
	
	public void setCountry(String country){
		if(country == null)
			throw new IllegalArgumentException("Country cannot be null.");
		this.country = country;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		if(city == null)
			throw new IllegalArgumentException("city cannot be null.");
		this.city = city;
	}
	
	public String getEpisodeName(){
		return episodeName;
	}
	
	public void setEpisodeName(String episodeName){
		if(episodeName == null)
			throw new IllegalArgumentException("The episode name cannot be null.");
		this.episodeName = episodeName;
	}
	
	public String getSeason(){
		return season;
	}
	
	public void setSeason(String season){
		if(season == null)
			throw new IllegalArgumentException("season name cannot be null.");
		this.season = season;
	}
	
	public int getEpisode(){
		return episode;
	}
	
	public void setEpisode(int episode){
		if(episode < 1)
			throw new IllegalArgumentException("The episode number must be greater than zero.");
		this.episode = episode;
	}
	
	public ArrayList<FoodItem> getFoodItems(){
		return foodItems;
	}
	
	public void addItem(FoodItem item){
		foodItems.add(item);
	}
	
	public void addItems(ArrayList<FoodItem> item){
		foodItems.addAll(item);
	}
}
