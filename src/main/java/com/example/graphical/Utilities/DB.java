package com.example.graphical.Utilities;

import com.example.graphical.Models.FoodItem;
import com.example.graphical.Models.Restaurant;

import java.io.*;
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
	
	public static Restaurant[] getRestaurants(){
		String sql = "SELECT * FROM restaurants";
		//using try with resources, we will open a connection, statement and resultSet to hold the data returned from the database
		Restaurant[] restaurants = null;
		try(Connection conn = DriverManager.getConnection(url); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(sql))
		{
			System.out.println("opsd");
			int i = 0;
			restaurants = new Restaurant[resultSet.getFetchSize()];
			//loop over the resultSet returned
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String notes = resultSet.getString("notes");
				String country = resultSet.getString("country");
				String city = resultSet.getString("city");
				String episodeName = resultSet.getString("epName");
				String season = resultSet.getString("season");
				int id = resultSet.getInt("id");
				int episode = resultSet.getInt("ep");
				ArrayList<FoodItem> foodItems = new ArrayList<>();
				ResultSet foodSet = statement.executeQuery("SELECT * FROM foods INNER JOIN foodsToRestaurants WHERE RestaurantID = " + id + ";");
				while(foodSet.next())
				{
					String foodName = foodSet.getString("name");
					double price = foodSet.getDouble("price");
					int pp = foodSet.getInt("pricePoint");
					FoodItem foodItem = new FoodItem(foodName, price, pp);
					foodItems.add(foodItem);
				}
				restaurants[i] = new Restaurant(season, episode, episodeName, name, city, country, notes);
				restaurants[i].addItem(foodItems);
				i++;
			}
//			salesData.getData().add(new XYChart.Data<>(resultSet.getString("name"), resultSet.getInt(2)));
		}
		catch(Exception e) {e.printStackTrace();}
		return restaurants;
	}
	
	public static ArrayList<Restaurant> readFromCSV(File file) throws FileNotFoundException{
////////Huge s/o to pauseforasecond for the spreadsheet based on the BuzzFeed show Is It Worth It.
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Scanner in = new Scanner(reader);
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		int i = 0;
		if(in.nextLine().equals("Season,Episode,Episode Name,Price Point,Restaurant,City,Country,Cost,Item,Notes"))
		{
			while(in.hasNextLine())
			{
				String test = in.nextLine();
				while(test.contains("\""))
				{
					while(test.split(",").length != 10)
					{
						if(test.contains("\""))
						{
							int firstApos = test.indexOf("\"");
							int nextApos = test.substring(firstApos + 1).indexOf("\"");
							if(nextApos == -1)
							{
								test = test.concat(";" + in.nextLine());
							}
							else
								test = test.substring(0, firstApos)
										+ test.substring(firstApos, nextApos + firstApos + 2).replaceAll("\"", "").replaceAll(",", "")
										+ test.substring(nextApos + firstApos + 2);
						}
						else
						{
							if(test.charAt(test.length() - 1) == ',')
								test = test.concat("null");
							else
								test = test.concat(",null");
						}
						
					}
					if(!closedApos(test) && test.contains("\""))
					{
						int firstApos = test.indexOf("\"");
						int nextApos = test.substring(firstApos + 1).indexOf("\"");
						if(nextApos == -1)
							test = test.concat(";" + in.nextLine());
						else
							test = test.substring(0, firstApos)
									+ test.substring(firstApos, nextApos + firstApos).replaceAll("\"", "")
									+ test.substring(nextApos + firstApos + 1);
					}
					else if(test.contains("\""))
					{
						int firstApos = test.indexOf("\"");
						int nextApos = test.substring(firstApos + 1).indexOf("\"") + firstApos + 1;
						test = test.substring(0, firstApos)
								+ test.substring(firstApos + 1, nextApos).replaceAll(",", "")
								+ test.substring(nextApos + 1);
					}
				}
				if(test.split(",").length != 10 && test.charAt(test.length() - 1) == ',')
					test += " ";
				String[] data = test.split(",");
				//Structure of data arr
				//Season,Episode,Episode Name,Price Point,Restaurant,City,Country,Cost,Item,Notes
				Restaurant restaurant = new Restaurant(data[0], Integer.parseInt(data[1]), data[2], data[4], data[5], data[6], data[8].replaceAll(";", ","));
				FoodItem item;
				if(data[7].isBlank() || data[7].isEmpty() || data[7].equalsIgnoreCase("n/a"))
					item = new FoodItem(data[8], null, data[3].length());
				else
					item = new FoodItem(data[8], Double.parseDouble(data[7].replaceAll("\\$", "")), data[3].length());
				if(restaurants.size() > 0)
				{
					if(restaurants.get(i - 1).getName().equalsIgnoreCase(restaurant.getName()))
						restaurants.get(i - 1).addItem(item);
					else
					{
						restaurant.addItem(item);
						restaurants.add(restaurant);
						i++;
					}
				}
				else
				{
					restaurant.addItem(item);
					restaurants.add(restaurant);
					i++;
				}
			}
		}
		else
			return null;
		return restaurants;
	}
	
	private static boolean closedApos(String test){
		if(test.contains("\""))
			return test.substring(test.indexOf("\"") + 1).contains("\"");
		return false;
	}
	
	private static String toNextCommDel(String line){
		return line.substring(0, line.indexOf(","));
	}
	
	public static void main(String[] args) throws IOException{
		ArrayList<Restaurant> restaurants = readFromCSV(new File("./src/main/resources/com/example/graphical/Restaurant List.csv"));
		File outFile = new File("src/main/resources/com/example/graphical/SQLScript-fromCSV.sql");
		if(!outFile.exists())
			System.out.println(outFile.createNewFile());
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		PrintWriter out = new PrintWriter(writer);
		out.println("# Huge s/o to pauseforasecond for the spreadsheet based on the BuzzFeed show Is It Worth It.");
		out.println("USE javaProjects;");
		for(Restaurant r : restaurants)
		{
			String country = r.getCountry();
			String epName = r.getEpisodeName();
			int ep = r.getEpisode();
			String notes = r.getNotes();
			String season = r.getSeason();
			String city = r.getCity();
			String name = r.getName();
			out.format("INSERT INTO restaurants (name,notes, country, city, `episode name`, season, episode) VALUES (%s,%s,%s,%s,%s,%s,%d);\n", name.translateEscapes(), notes.translateEscapes(), country.translateEscapes(), city.translateEscapes(), epName.translateEscapes(), season.translateEscapes(), ep);
			out.flush();
			writer.flush();
			
		}
		out.close();
		writer.close();
		System.out.println(outFile.exists());
		System.out.println(outFile.getName());
		System.out.println(outFile.getAbsolutePath());
		
	}
}
