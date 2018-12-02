package edu.cloudtech.FoodBolt.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SignUpRequest {

	private String name;

	private String signupRole;
	
    private String firstName;
   
    private String lastName;
    
    @Size(min=6, max=30)
    private String email;

    @Size(min=6, max=50)
    private String password;
    
    @Size(min=1, max=50)
    private String city;

    private String state;

    @Size(min=1, max=100)
    private String cuisine;

    private int guests;
    
    private int totalTables;
    
    private int totalOccupancy;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public String getSignupRole() {
		return signupRole;
	}

	public void setSignupRole(String signupRole) {
		this.signupRole = signupRole;
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
	
	
	
}
