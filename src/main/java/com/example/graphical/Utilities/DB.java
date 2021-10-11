package com.example.graphical.Utilities;

import com.example.graphical.Models.Restaurant;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DB{
	private static final String user = "student";
	private static final String pw = "student";
	private static final String url = "jdbc:mysql://localhost:3306/javaProjects";
	
	public static XYChart.Series<String, Integer> getRestaurants(){
		XYChart.Series<String, Integer> salesData = new XYChart.Series<>();
		String sql = "SELECT * FROM restaurants";
		//using try with resources, we will open a connection, statement and resultSet to hold the data returned from the database
		try(Connection conn = DriverManager.getConnection(url, user, pw);
		    Statement statement = conn.createStatement();
		    ResultSet resultSet = statement.executeQuery(sql))
		{
			//loop over the resultSet returned and build the XYChart data
			while(resultSet.next())
				salesData.getData().add(new XYChart.Data<>(resultSet.getString("company"), resultSet.getInt(2)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return salesData;
	}
	
	public static ArrayList<Restaurant> readFromCSV(File file) throws FileNotFoundException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Scanner in = new Scanner(reader);
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		if(in.nextLine().equals("Season,Episode,Episode Name,Price Point,Restaurant,City,Country,Cost,Item,Notes"))
			while(in.hasNextLine())
			{
				String line = in.nextLine();
				String name = line.substring(0, line.indexOf(','));
				System.out.println(line);
			}
		else
			return null;
		return restaurants;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		readFromCSV(new File("./src/main/resources/com/example/graphical/Restaurant List.csv"));
	}
}
