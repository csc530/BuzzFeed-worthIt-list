package com.example.graphical.Controllers;

import com.example.graphical.Models.Restaurant;
import com.example.graphical.Utilities.Session;
import com.example.graphical.Utilities.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addRestaurantController implements Initializable{
	@FXML
	private TextField name;
	@FXML
	private TextField city;
	@FXML
	private TextField country;
	@FXML
	private TextField notes;
	@FXML
	private Label err;
	
	@FXML
	void addFoods(ActionEvent event){
	}
	
	@FXML
	void create(ActionEvent event) throws IOException{
		String name = this.name.getText();
		String city = this.city.getText();
		String country = this.country.getText();
		String notes = this.notes.getText();
		if(name.length() > 2 && city.length() > 2 && country.length() > 2)
		{
			Session.getRestaurants().add(new Restaurant(name, city, country, notes));
			Transition.to(event, "tableView.fxml", "Restaurant Tables");
		}
		else
		{
			if(name.length() < 2)
				err.setText("Restaurant name must be greater than 2 characters.");
			else if(country.length() < 2)
				err.setText("Country must be greater than 2 characters.");
			else
				err.setText("City must be greater than 2 characters.");
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		err.setText("");
	}
}
