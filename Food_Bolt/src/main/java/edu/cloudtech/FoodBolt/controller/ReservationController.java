package edu.cloudtech.FoodBolt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cloudtech.FoodBolt.dao.TableReservation;
import edu.cloudtech.FoodBolt.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
//	@RequestMapping(value = "/reserveTable", method = RequestMethod.GET)
//	public List getAllCustomers() {
//		
//		System.out.println("In All Customer controller");
//		System.out.println("CUstomer Details" + customerDetailService.getAllCustomers());
//		return customerDetailService.getAllCustomers();
//		
//	}
	
	@RequestMapping(value = "/reserveTable", method = RequestMethod.POST)
	public String  reserveTable() {
		
		TableReservation reserv = new TableReservation();
		Date d = new Date();
		System.out.println("Date " + d);
		reserv.setRestaurantID(1);;
		reserv.setUserID(2);
		reserv.setBookingTime(d);
		reserv.setBookingDate(d);
		reserv.setNo_of_guests(5);
		
		 reservationService.reserveTable(reserv);
		
		 return "Success";
	
	}
	
	@RequestMapping(value = "/reserveTable/{bookingID}", method = RequestMethod.POST)
	public TableReservation  getReservation(@PathVariable int bookingID) {
		
		//Need to test this
		TableReservation reserv = new TableReservation();
		 return reservationService.getReservationByID(bookingID);
	
	}
	
	@RequestMapping(value = "/findAvailability/{restID}", method = RequestMethod.POST)
	public TableReservation  findAvailability(@PathVariable int restID) {
		
		//Need to test this
		TableReservation reserv = new TableReservation();
		 return reservationService.getReservationByID(restID);
	
	}
	
	
	
	

}
