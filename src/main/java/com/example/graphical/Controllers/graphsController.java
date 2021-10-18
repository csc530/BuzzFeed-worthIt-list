package com.example.graphical.Controllers;

import com.example.graphical.Utilities.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

import java.net.URL;
import java.util.ResourceBundle;

public class graphsController implements Initializable{
	
	@FXML
	private BarChart<?, ?> graph;
	
	@FXML
	void addResto(ActionEvent event) {
	
	}
	
	@FXML
	void toTable(ActionEvent event) {
	
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		DB.getRestaurants();
	}
}
