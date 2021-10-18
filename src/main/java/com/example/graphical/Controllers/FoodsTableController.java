package com.example.graphical.Controllers;

import com.example.graphical.Models.FoodItem;
import com.example.graphical.Utilities.Session;
import com.example.graphical.Utilities.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodsTableController implements Initializable{
	@FXML
	private TableView<FoodItem> table;
	@FXML
	private TableColumn<FoodItem, String> name;
	@FXML
	private TableColumn<FoodItem, Double> price;
	@FXML
	private TableColumn<FoodItem, Integer> pricePoint;
	
	@FXML
	void addRestaurant(ActionEvent event) throws IOException{
		Transition.to(event, "addRestuarantView.fxml", "Create a Restaurant");
	}
	
	@FXML
	void toGraph(ActionEvent event) throws IOException{
		Transition.to(event, "graphsView.fxml", "Restaurant graph");
	}
	
	@FXML
	void toRestaurantsTable(ActionEvent event) throws IOException{
		Session.setEditingRestaurant(null);
		Transition.to(event, "tableView.fxml", "Restaurants Tables");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		pricePoint.setCellValueFactory(new PropertyValueFactory<>("pricePoint"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		table.getItems().addAll(Session.getEditingRestaurant().getFoodItems());
	}
}
