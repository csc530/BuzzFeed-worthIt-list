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
		Transition.to(event,"addRestuarantView.fxml", "AddRestaurant");
	}
	
	@FXML
	void toTable(ActionEvent event) throws IOException{
		Transition.to(event,"tableView.fxml", "Restaurants");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		List<Restaurant> restaurants = Session.getRestaurants();
		XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
		for(Restaurant r : restaurants)
		{
			double price = r.getFoodItems().stream().mapToDouble(FoodItem::getPrice).sum();
			series.getData().add(new XYChart.Data<String, Double>(r.getName(), price));
		}
		graph.getData().addAll(series);
	}
	
	@FXML
	void view10(ActionEvent event) throws IOException{
		Session.randomRefreshRestaurants(10);
		Transition.to(event,"graphsView.fxml", "BuzzFeed's Worth It graph");
	}
	
	@FXML
	void viewAll(ActionEvent event) throws IOException{
		Session.randomRefreshRestaurants();
		Transition.to(event,"graphsView.fxml", "BuzzFeed's Worth It graph");
	}
}