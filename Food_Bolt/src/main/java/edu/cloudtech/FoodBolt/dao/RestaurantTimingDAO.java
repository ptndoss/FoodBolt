package edu.cloudtech.FoodBolt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantTimingDAO extends CrudRepository<RestaurantTiming, RestaurantDay> {

	List<RestaurantTiming> findAll();
	 
    Optional<RestaurantTiming> findById(RestaurantDay restaurantDay);
    
    
	
	
	
}
