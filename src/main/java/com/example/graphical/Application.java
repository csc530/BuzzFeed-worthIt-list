package com.example.graphical;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//I need to create an application that loads a graph of unemployed/employed jobs in Canada
public class Application extends javafx.application.Application{
	@Override
	public void start(Stage stage) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/graphView.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("My App");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args){
		launch();
	}
}