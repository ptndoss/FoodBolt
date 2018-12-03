package edu.cloudtech.FoodBolt.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SERVICE_PROVIDER")
public class ServiceProvider {

	
	@Id
	@Column(name = "RESTAURANT_ID")
	long restaurant_id;
	
	@Column(name = "RESTAURANT_NAME")
	String name;
	
	@Column(name = "EMAIL")
	String email;
	
	@Column(name = "CITY")
	String city;
	
	@Column(name = "STATE")
	String state;
	
	@Column(name = "CUISINE")
	String cuisine;
	
	@Column(name = "TOTAL_TABLES")
	int totalTables;
	
	@Column(name = "TOTAL_OCCUPANCY")
	int totalOccupancy;
	
	@Column(name = "IS_ACTIVE")
	String is_active;
	
	@Column(name = "SIGNUP_ROLE")
    private String signupRole;

	@Column(name = "IMAGE_URL")
    private String imageUrl;

    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "PROVIDER")
    private AuthProvider provider;
    
	public ServiceProvider() {
		super();
	}
	

	public ServiceProvider(String name, String email, String city, String state, String cuisine,
			int totalTables, int totalOccupancy) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.state = state;
		this.cuisine = cuisine;
		this.totalTables = totalTables;
		this.totalOccupancy = totalOccupancy;
	}

	public String getSignupRole() {
		return signupRole;
	}

	public void setSignupRole(String signupRole) {
		this.signupRole = signupRole;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthProvider getProvider() {
		return provider;
	}


	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}
	
	public long getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getTotalTables() {
		return totalTables;
	}

	public void setTotalTables(int totalTables) {
		this.totalTables = totalTables;
	}

	public int getTotalOccupancy() {
		return totalOccupancy;
	}

	public void setTotalOccupancy(int totalOccupancy) {
		this.totalOccupancy = totalOccupancy;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	
	
}
