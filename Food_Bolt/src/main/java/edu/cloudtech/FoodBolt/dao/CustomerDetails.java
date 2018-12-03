package edu.cloudtech.FoodBolt.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.cloudtech.FoodBolt.dao.AuthProvider;

@Entity
@Table(name = "CUST_DETAILS")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID")
	long cust_id;

    @Column(name = "SIGNUP_ROLE")
    private String signupRole;
    
	@Column(name = "FIRST_NAME")
	String first_name;
	
	@Column(name = "LAST_NAME")
	String last_name;
	
	@Column(name = "EMAIL")
	String email;
		
	@Column(name = "CITY")
	String city;
	
	@Column(name = "STATE")
	String state;
	
	@Column(name = "CUISINE")
	String cuisine;
	
	@Column(name = "DEFAULT_GUESTS")
	int default_guests;
	
	@Column(name = "IS_ACTIVE")
	String is_active;
	
	@Column(name = "PASSWORD")
	String password;
	
	@Column(name = "IMAGE_URL")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "PROVIDER")
    private AuthProvider provider;
    
	public CustomerDetails(String first_name, String last_name, String email, String city,
			String state, String cuisine, int default_guests) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.city = city;
		this.state = state;
		this.cuisine = cuisine;
		this.default_guests = default_guests;
	}
	
	public CustomerDetails() {
		super();
	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	
	public String getSignupRole() {
		return signupRole;
	}

	public void setSignupRole(String signupRole) {
		this.signupRole = signupRole;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public int getDefault_guests() {
		return default_guests;
	}

	public void setDefault_guests(int default_guests) {
		this.default_guests = default_guests;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}
	

}
