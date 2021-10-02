package com.example.graphical.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class graphsController{
	@FXML
	private Label welcomeText;
	
	@FXML
	protected void onHelloButtonClick(){
		welcomeText.setText("Welcome to JavaFX Application!");
	}
}