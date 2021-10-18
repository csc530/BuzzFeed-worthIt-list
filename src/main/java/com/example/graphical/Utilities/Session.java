package com.example.graphical.Utilities;

import com.example.graphical.Models.Restaurant;

import java.util.ArrayList;
import java.util.Collections;

public class Session{
	private static ArrayList<Restaurant> restaurants = DB.getRestaurants();
	private static Restaurant editingRestaurant = null;
	
	public static Restaurant getEditingRestaurant(){
		return editingRestaurant;
	}
	
	public static void setEditingRestaurant(Restaurant editingRestaurant){
		Session.editingRestaurant = editingRestaurant;
	}
	
	public static ArrayList<Restaurant> refreshRestaurants(){
		return restaurants = DB.getRestaurants();
	}
	
	public static ArrayList<Restaurant> refreshRestaurants(int size){
		reduceToFirstX(size);
		return restaurants;
	}
	
	public static ArrayList<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	public static ArrayList<Restaurant> shuffle(){
		Collections.shuffle(restaurants);
		return restaurants;
	}
	
	public static ArrayList<Restaurant> randomRefreshRestaurants(){
		refreshRestaurants();
		return shuffle();
	}
	
	public static ArrayList<Restaurant> randomRefreshRestaurants(int size){
		randomRefreshRestaurants();
		reduceToFirstX(size);
		return restaurants;
	}
	
	private static void reduceToFirstX(int size){
		ArrayList<Restaurant> temp = new ArrayList<>(restaurants.subList(0, size));
		restaurants.clear();
		restaurants.addAll(temp);
	}
}
