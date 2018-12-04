package edu.cloudtech.FoodBolt.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FOOD_LIST")
public class FoodList {
	
	
	private String restaurant_id;
	private String category;
	private FoodAppetizer appetizer;
	private FoodMainCourse maincourse;
	private FoodDessert dessert;

	
	
	public FoodList() {
		super();
	}
	
	
	
	public FoodList(String restaurant_id, String category, FoodAppetizer appetizer, FoodMainCourse maincourse, FoodDessert dessert) {
		super();
		this.restaurant_id = restaurant_id;
		this.category = category;
		this.appetizer = appetizer;
		this.maincourse = maincourse;
		this.dessert = dessert;
	}
	
//	(attributeName = "RESTAURANT_ID")
	@DynamoDBHashKey(attributeName = "RESTAURANT_ID")
	@DynamoDBAttribute
	public String getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
//	(attributeName = "CATEGORY")
	@DynamoDBAttribute
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
//	(attributeName = "APPETIZER")
	@DynamoDBAttribute
	public FoodAppetizer getAppetizer() {
		return appetizer;
	}
	public void setAppetizer(FoodAppetizer appetizer) {
		this.appetizer = appetizer;
	}
//	(attributeName = "MAINCOURSE")
	@DynamoDBAttribute
	public FoodMainCourse getMaincourse() {
		return maincourse;
	}
	public void setMaincourse(FoodMainCourse maincourse) {
		this.maincourse = maincourse;
	}
	
//	(attributeName = "DESSERT")
	@DynamoDBAttribute
	public FoodDessert getDessert() {
		return dessert;
	}
	public void setDessert(FoodDessert dessert) {
		this.dessert = dessert;
	}

}
