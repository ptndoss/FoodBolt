package edu.cloudtech.FoodBolt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ServiceProviderDAO extends CrudRepository<ServiceProvider,Integer> {

	List<ServiceProvider> findAll();
	 
    Optional<ServiceProvider> findById(Integer RESTAURANT_ID);
	
}
