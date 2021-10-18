package com.example.graphical;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application{
	@Override
	public void start(Stage stage) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/graphsView.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.getIcons().add(new Image("logo.jpg"));
		stage.show();
	}
	
	public static void main(String[] args){
		launch();
	}
}