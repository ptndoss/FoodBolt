package edu.cloudtech.FoodBolt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDetailsDAO extends CrudRepository<CustomerDetails,Long> {

	List<CustomerDetails> findAll();
	 
    Optional<CustomerDetails> findById(Long cust_id);

    Optional<CustomerDetails> findByEmail(String email);

    Boolean existsByEmail(String email);
    
}
