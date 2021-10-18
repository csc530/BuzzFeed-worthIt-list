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
import java.util.ResourceBundle;
import java.util.stream.DoubleStream;

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
		Restaurant[] restaurants = DB.getRestaurants();
		XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
		for(Restaurant r : restaurants)
		{
			double price = r.getFoodItems().stream().mapToDouble(FoodItem::getPrice).sum();
			//price/=r.getFoodItems().size();System.out.println(price);
			series.getData().add(new XYChart.Data<String, Double>(r.getName(), price));
		}
		graph.getData().addAll(series);
	}
}