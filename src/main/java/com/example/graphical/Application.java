package com.example.graphical;

import com.example.graphical.Utilities.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application{
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage stage) throws IOException{
		Session.randomRefreshRestaurants(20);
		FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/graphsView.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("BuzzFeed's Worth It graph!");
		stage.setScene(scene);
		stage.getIcons().add(new Image("logo.jpg"));
		stage.show();
	}
}