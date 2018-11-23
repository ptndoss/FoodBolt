package edu.cloudtech.FoodBolt.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RESTAURANT_TIMINGS")
public class RestaurantTiming {
	
	@EmbeddedId
	RestaurantDay restaurantDay;
	
	@Column(name = "TIMING_MORNING")
	@Temporal(TemporalType.TIMESTAMP)
	Date timing_morning;
	
	@Column(name = "TIMING_NOON")
	Date timing_noon;
	
	@Column(name = "TIMING_EVENING")
	@Temporal(TemporalType.TIMESTAMP)
	Date timing_evening;

	
	public RestaurantTiming() {
		super();
	}	
	
	
	
	public RestaurantTiming(String day, Date timing_morning, Date timing_noon, Date timing_evening) {
		super();
		this.timing_morning = timing_morning;
		this.timing_noon = timing_noon;
		this.timing_evening = timing_evening;
	}

	
	public RestaurantDay getRestaurantDay() {
		return restaurantDay;
	}



	public void setRestaurantDay(RestaurantDay restaurantDay) {
		this.restaurantDay = restaurantDay;
	}



	public Date getTiming_morning() {
		return timing_morning;
	}

	public void setTiming_morning(Date timing_morning) {
		this.timing_morning = timing_morning;
	}

	public Date getTiming_noon() {
		return timing_noon;
	}

	public void setTiming_noon(Date timing_noon) {
		this.timing_noon = timing_noon;
	}

	public Date getTiming_evening() {
		return timing_evening;
	}

	public void setTiming_evening(Date timing_evening) {
		this.timing_evening = timing_evening;
	}
	
	
	
	

}
