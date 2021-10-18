package com.example.graphical.Utilities;

import com.example.graphical.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Transition{
	public static void to(ActionEvent event, String fxmlFile, String title) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Views/" + fxmlFile));
		Scene scene = new Scene(fxmlLoader.load());
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}
}
