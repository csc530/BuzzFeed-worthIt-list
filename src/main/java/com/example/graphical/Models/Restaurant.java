package com.example.graphical.Models;

import java.util.ArrayList;

public class Restaurant{
	private String name, notes, country, city,episodeName, season;
	private int id, episode;
	private ArrayList<FoodItem> foodItems;
	
	public Restaurant(String season, int episode, String episodeName, String name,String city,String country, String notes){
		setCity(city);
		setName(name);
		setNotes(notes);
		setCountry(country);
		setEpisode(episode);
		setEpisodeName(episodeName);
		setSeason(season);
		foodItems = new ArrayList<FoodItem>();
 	}
	
	public void setName(String name){
		if(name.length()<3)
			throw new IllegalArgumentException("Name must be at least 3 characters long.");
		this.name = name;
	}
	
	public void setNotes(String notes){
		if(notes == null)
		throw new IllegalArgumentException("Notes cannot be null.");
		this.notes = notes;
	}
	
	public void setCountry(String country){
		if(country == null)
			throw new IllegalArgumentException("Country cannot be null.");
		this.country = country;
	}
	
	public void setCity(String city){
		if(city == null)
		throw new IllegalArgumentException("city cannot be null.");
		this.city = city;
	}
	
	public void setEpisodeName(String episodeName){
		if(episodeName == null)
			throw new IllegalArgumentException("The episode name cannot be null.");
		this.episodeName = episodeName;
	}
	
	public void setSeason(String season){
		if(season == null)
			throw new IllegalArgumentException("season name cannot be null.");
		this.season = season;
	}
	
	public void setEpisode(int episode){
		this.episode = episode;
	}
	
	public void setName(String name){
		if(name.length()<3)
			throw new IllegalArgumentException("Name must be at least 3 characters long.");
		this.name = name;
	}
	
	public void setNotes(String notes){
		if(notes == null)
		throw new IllegalArgumentException("Notes cannot be null.");
		this.notes = notes;
	}
	
	public void setCountry(String country){
		if(country == null)
			throw new IllegalArgumentException("Country cannot be null.");
		this.country = country;
	}
	
	public void setCity(String city){
		if(city == null)
		throw new IllegalArgumentException("city cannot be null.");
		this.city = city;
	}
	
	public void setEpisodeName(String episodeName){
		if(episodeName == null)
			throw new IllegalArgumentException("The episode name cannot be null.");
		this.episodeName = episodeName;
	}
	
	public void setSeason(String season){
		if(season == null)
			throw new IllegalArgumentException("season name cannot be null.");
		this.season = season;
	}
	
	public void setEpisode(int episode){
		this.episode = episode;
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
	
	public void addItems(ArrayList<FoodItem> item){
		foodItems.addAll(item);
	}
}
