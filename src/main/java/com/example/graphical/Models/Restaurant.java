package com.example.graphical.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Restaurant{
	public static ArrayList<String> CategoryList = (ArrayList<String>) Arrays.asList(new String[]{"Diner", "Fast food", "Fancy", "Other", "Unspecified"});
	private String name, category;
	private int id, locations;
	private boolean active;
	private double value;
	private Date established;
	
	public Restaurant(String name, String category, int id, int locations, boolean active, double value, Date established){
		this.name = name;
		this.category = category;
		this.id = id;
		this.locations = locations;
		this.active = active;
		this.value = value;
		this.established = established;
	}
	
	public Restaurant(String name, boolean active, int locations, Date established){
		this.name = name;
	}
	public Restaurant(String name, boolean active, int locations, Date established, String category){
		this(name, active,locations, established);
	}
	public Restaurant(String name, boolean active, int locations, Date established, String category, double value){
		
		this(name, active,locations, established, category);
	}
	
}
