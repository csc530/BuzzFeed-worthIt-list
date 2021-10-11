package com.example.graphical.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Restaurant{
	public static ArrayList<String> CategoryList = (ArrayList<String>) Arrays.asList(new String[]{"Diner", "Fast food", "Fancy", "Other", "Unspecified"});
	private String name, notes, country, city;
	private int id, season, episode;
	private ArrayList<FoodItem> foodItems;
	
	public Restaurant(String name, String notes, String country, String city, int id, int season, int episode, ArrayList<FoodItem> foodItems){
		this.name = name;
		this.notes = notes;
		this.country = country;
		this.city = city;
		this.id = id;
		this.season = season;
		this.episode = episode;
		this.foodItems = foodItems;
	}
}
