package com.example.graphical.Controllers;

import com.example.graphical.Models.FoodItem;
import com.example.graphical.Utilities.DB;
import com.example.graphical.Utilities.Session;
import com.example.graphical.Utilities.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addFoodsController implements Initializable{
	@FXML
	private Label title;
	@FXML
	private TableView<FoodItem> foodsTable;
	
	@FXML
	private TableColumn<FoodItem, String> nameCol;
	
	@FXML
	private TableColumn<FoodItem, Double> priceCol;
	
	@FXML
	private TableColumn<FoodItem, Integer> ppCol;
	
	@FXML
	private TextField name;
	
	@FXML
	private Spinner<Double> price;
	
	@FXML
	private Spinner<Integer> pricePoint;
	
	@FXML
	private Label err;
	
	
	@FXML
	void done(ActionEvent event) throws IOException, SQLException{
		DB.upload(Session.getEditingRestaurant());
		Session.setEditingRestaurant(null);
		Transition.to(event,"tableView.fxml", "Restaurant tables");
	}
	
	@FXML
	void remove(ActionEvent event) {
		int row  = foodsTable.getEditingCell().getRow();
		if(row ==-1)
			err.setText("No food selected from table");
		else
		{
			String name = nameCol.getCellObservableValue(row).getValue();
			int pp = ppCol.getCellObservableValue(row).getValue();
			double price = priceCol.getCellObservableValue(row).getValue();
			Session.getEditingRestaurant().getFoodItems().remove(new FoodItem(name, price,pp));
		}
	}
	@FXML
	void create(ActionEvent event) {
		double price = this.price.getValue();
		int pp = this.pricePoint.getValue();
		String name = this.name.getText();
		if(name.length() <2)
			err.setText("Name must be at least 2 characters.");
		else
		{
			Session.getEditingRestaurant().addItem(new FoodItem(name,price,pp));
			refresh();
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		pricePoint.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,3,1));
		pricePoint.getValueFactory().setWrapAround(true);
		price.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.010,100,10));
		price.getValueFactory().setWrapAround(true);
		ppCol.setCellValueFactory(new PropertyValueFactory<>("pricePoint"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		title.setText("Add Dishes to " +Session.getEditingRestaurant().getName());
		refresh();
	}
	
	public void refresh(){
		foodsTable.getItems().clear();
		foodsTable.getItems().addAll(Session.getEditingRestaurant().getFoodItems());
		err.setText("");
	}
}
