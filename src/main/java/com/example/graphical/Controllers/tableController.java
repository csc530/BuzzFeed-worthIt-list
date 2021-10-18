package com.example.graphical.Controllers;

import com.example.graphical.Models.Restaurant;
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


public class tableController implements Initializable{
	
	@FXML
	private TableView<Restaurant> table;
	
	@FXML
	private TableColumn<Restaurant, String> season;
	
	@FXML
	private TableColumn<Restaurant, Integer> episode;
	
	@FXML
	private TableColumn<Restaurant, String> epName;
	
	@FXML
	private TableColumn<Restaurant, String> name;
	
	@FXML
	private TableColumn<Restaurant, String> country;
	
	@FXML
	private TableColumn<Restaurant, String> city;
	
	@FXML
	private TableColumn<Restaurant, String> notes;
	
	@FXML
	void addRestaurant(ActionEvent event) {
	
	}
	
	@FXML
	void toGraph(ActionEvent event) throws IOException{
		Transition.to(event,"graphsView.fxml","Restaurant graph");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		season.setCellValueFactory(new PropertyValueFactory<>("season"));
		notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
		episode.setCellValueFactory(new PropertyValueFactory<>("episode"));
		epName.setCellValueFactory(new PropertyValueFactory<>("episodeName"));
		country.setCellValueFactory(new PropertyValueFactory<>("country"));
		city.setCellValueFactory(new PropertyValueFactory<>("city"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		table.getItems().addAll(Session.getRestaurants());
	}
}
