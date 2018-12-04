package edu.cloudtech.FoodBolt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TableReservationDAO extends CrudRepository<TableReservation, Integer>{

	
	List<TableReservation> findAll();
	 
    Optional<TableReservation> findById(int  BookingID);
    
    
}
