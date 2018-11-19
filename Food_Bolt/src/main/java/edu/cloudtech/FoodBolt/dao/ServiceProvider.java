package edu.cloudtech.FoodBolt.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_PROVIDER")
public class ServiceProvider {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESTAURANT_ID")
	int restaurant_id;
	
	@Column(name = "RESTAURANT_NAME")
	String restaurant_name;
	
	@Column(name = "EMAIL")
	String email;
	
	@Column(name = "CITY")
	String city;
	
	@Column(name = "STATE")
	String state;
	
	@Column(name = "CUISINE_TYPE")
	String cuisine_typ;
	
	@Column(name = "TOT_TBLS_AVALBL")
	int total_tables;
	
	@Column(name = "TOTAL_OCCUPANCY")
	int total_occupancy;
	
	@Column(name = "IS_ACTIVE")
	String is_active;
	
	
	public ServiceProvider() {
		super();
	}
	

	public ServiceProvider(String restaurant_name, String email, String city, String state, String cuisine_typ,
			int total_tables, int total_occupancy) {
		super();
		this.restaurant_name = restaurant_name;
		this.email = email;
		this.city = city;
		this.state = state;
		this.cuisine_typ = cuisine_typ;
		this.total_tables = total_tables;
		this.total_occupancy = total_occupancy;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCuisine_typ() {
		return cuisine_typ;
	}

	public void setCuisine_typ(String cuisine_typ) {
		this.cuisine_typ = cuisine_typ;
	}

	public int getTotal_tables() {
		return total_tables;
	}

	public void setTotal_tables(int total_tables) {
		this.total_tables = total_tables;
	}

	public int getTotal_occupancy() {
		return total_occupancy;
	}

	public void setTotal_occupancy(int total_occupancy) {
		this.total_occupancy = total_occupancy;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	
	
}
