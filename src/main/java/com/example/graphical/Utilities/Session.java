package com.example.graphical.Utilities;

import com.example.graphical.Models.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Session{
	private static ArrayList<Restaurant> restaurants = DB.getRestaurants();
	
	public static ArrayList<Restaurant> refreshRestaurants() {
		return restaurants = DB.getRestaurants();
	}
	
	public static ArrayList<Restaurant> refreshRestaurants(int size) {
		List<Restaurant> temp = DB.getRestaurants().subList(0, size);
		restaurants.removeIf(r->true);
		restaurants.addAll(temp);
		return restaurants;
	}
	
	public static ArrayList<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	public static ArrayList<Restaurant> shuffle(){
		Collections.shuffle(restaurants);
		return restaurants;
	}
	
	public static ArrayList<Restaurant> randomRefreshRestaurants() {
		refreshRestaurants();
		return shuffle();
	}
	public static ArrayList<Restaurant> randomRefreshRestaurants(int size) {
		refreshRestaurants();
		List<Restaurant> temp = DB.getRestaurants().subList(0, size);
		restaurants.removeIf(r->true);
		restaurants.addAll(temp);
		return restaurants;
	}
}
