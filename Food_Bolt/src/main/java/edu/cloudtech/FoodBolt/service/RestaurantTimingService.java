package edu.cloudtech.FoodBolt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cloudtech.FoodBolt.dao.RestaurantDay;
import edu.cloudtech.FoodBolt.dao.RestaurantTiming;
import edu.cloudtech.FoodBolt.dao.RestaurantTimingDAO;

@Service
public class RestaurantTimingService {

	@Autowired
	RestaurantTimingDAO restauranttimingDAO;
	
	public List getAllRestaurantTimings() {
		
		List timingList = new ArrayList<>();
		restauranttimingDAO.findAll().forEach(timingList::add);
		System.out.println("List Of Restaurant Time" + timingList);
		return timingList;
		
		}
	
	public RestaurantTiming getRestaurantTimings(RestaurantDay RestDay) {
		
		System.out.println("Restaurant Keys" + RestDay);
		
//		List<CustomerDetails> cust = customerdetailsDAO.findById(cust_id);
		
//		Optional<CustomerDetails> optCustomerDetails = customerdetailsDAO.findById(cust_id).orElse(null);
//		System.out.println("In Service Class" + optCustomerDetails);
//		CustomerDetails customerDetails = optCustomerDetails.get();
		
		RestaurantTiming restaurantTiming = restauranttimingDAO.findById(RestDay).orElse(null);
		
//		
//		Date today = new Date();
//        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEEE");
//        simpleDateformat.format(today);
//		
//        
        
		return restaurantTiming;
		
	}
	

	public void addRestaurantTiming(RestaurantTiming restaurantTiming) {
		restauranttimingDAO.save(restaurantTiming);
	}
	

	
	
	
	
}
