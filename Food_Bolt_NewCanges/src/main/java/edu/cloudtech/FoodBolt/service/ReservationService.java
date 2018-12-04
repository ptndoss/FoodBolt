package edu.cloudtech.FoodBolt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.TableReservation;
import edu.cloudtech.FoodBolt.dao.TableReservationDAO;

import java.util.Optional;



@Service
public class ReservationService {
	
	@Autowired
	private TableReservationDAO tableReservationDAO;
	
	public void reserveTable(TableReservation tableReserve) {
		tableReservationDAO.save(tableReserve);
	}
	
	public TableReservation getReservationByID(int BookingID) {
		System.out.println("Booking ID " + BookingID);
		return tableReservationDAO.findById(BookingID).orElse(null);
	}
	
	

}
