package com.example.graphical.Controllers;

import com.example.graphical.Models.Restaurant;
import com.example.graphical.Utilities.Session;
import com.example.graphical.Utilities.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class tableController implements Initializable{
	@FXML
	private TableView<Restaurant> table;
	@FXML
	private TableColumn<Restaurant, String> season;
	@FXML
	private TableColumn<Restaurant, Integer> episode;
	@FXML
	private TableColumn<Restaurant, String> episodeName;
	@FXML
	private TableColumn<Restaurant, String> name;
	@FXML
	private TableColumn<Restaurant, String> country;
	@FXML
	private TableColumn<Restaurant, String> city;
	@FXML
	private TableColumn<Restaurant, String> notes;
	
	@FXML
	void addRestaurant(ActionEvent event) throws IOException{
		Transition.to(event, "addRestuarantView.fxml", "Create a Restaurant");
	}
	
	@FXML
	void toGraph(ActionEvent event) throws IOException{
		Transition.to(event, "graphsView.fxml", "Restaurant graph");
	}
	
	@FXML
	void toFoodsTable(ActionEvent event) throws IOException{
		int index = table.getFocusModel().getFocusedIndex();
		System.out.println(index + "");
		if(index > -1)
		{
			Session.setEditingRestaurant(Session.getRestaurants().get(index));
			Transition.to(event, "foodsTableView.fxml",Session.getRestaurants().get(index).getName()+" Foods Table");
		}
		else
			new Alert(Alert.AlertType.ERROR, "No Restaurant Selected", ButtonType.OK).show();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		season.setCellValueFactory(new PropertyValueFactory<>("season"));
		notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
		episode.setCellValueFactory(new PropertyValueFactory<>("episode"));
		episodeName.setCellValueFactory(new PropertyValueFactory<>("episodeName"));
		country.setCellValueFactory(new PropertyValueFactory<>("country"));
		city.setCellValueFactory(new PropertyValueFactory<>("city"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		table.getItems().addAll(Session.getRestaurants());
	}
}
