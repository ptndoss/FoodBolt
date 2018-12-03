package edu.cloudtech.FoodBolt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderDAO extends CrudRepository<ServiceProvider, Long> {

	List<ServiceProvider> findAll();
	 
    Optional<ServiceProvider> findById(Long RESTAURANT_ID);

    Optional<ServiceProvider> findByEmail(String email);

    Boolean existsByEmail(String email);
    
}
