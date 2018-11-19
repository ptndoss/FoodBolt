package edu.cloudtech.FoodBolt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDetailsDAO extends CrudRepository<CustomerDetails,Integer> {

	List<CustomerDetails> findAll();
	 
    Optional<CustomerDetails> findById(Integer cust_id);
	
}
