package edu.cloudtech.FoodBolt.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RestaurantDay implements Serializable {

	@Column(name = "RESTAURANT_ID")
	int restaurant_id;
	
	@Column(name = "DAY")
	String Day;

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}
	
	
	
}
