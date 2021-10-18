package com.example.graphical.Controllers;

import com.example.graphical.Models.*;
import com.example.graphical.Utilities.DB;
import com.example.graphical.Utilities.Session;
import com.example.graphical.Utilities.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class graphsController implements Initializable{
	@FXML
	private BarChart<String, Double> graph;
	@FXML
	private CategoryAxis xAx;
	@FXML
	private NumberAxis yAx;
	
	@FXML
	void addRestaurant(ActionEvent event) throws IOException{
		Transition.to(event,"AddRestaurantView", "AddRestaurant");
	}
	
	@FXML
	void toTable(ActionEvent event) throws IOException{
		Transition.to(event,"tableView", "Restaurants");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		List<Restaurant> restaurants = Session.getRestaurants();
		if(restaurants.size()>12)//add a prompt to user if they'd like to refresh
			restaurants=Session.randomRefreshRestaurants(10);
		XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
		for(Restaurant r : restaurants)
		{
			double price = r.getFoodItems().stream().mapToDouble(FoodItem::getPrice).sum();
			series.getData().add(new XYChart.Data<String, Double>(r.getName(), price));
		}
		graph.getData().addAll(series);
	}
}