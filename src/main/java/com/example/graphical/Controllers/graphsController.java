package com.example.graphical.Controllers;

import com.example.graphical.Models.*;
import com.example.graphical.Utilities.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

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
	void addResto(ActionEvent event){
	}
	
	@FXML
	void toTable(ActionEvent event){
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		List<Restaurant> restaurants = DB.getRestaurants();
		Collections.shuffle(restaurants);
		restaurants = restaurants.subList(0,9);
		XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
		for(Restaurant r : restaurants)
		{
			double price = r.getFoodItems().stream().mapToDouble(FoodItem::getPrice).sum();
			series.getData().add(new XYChart.Data<String, Double>(r.getName(), price));
		}
		graph.getData().addAll(series);
	}
}