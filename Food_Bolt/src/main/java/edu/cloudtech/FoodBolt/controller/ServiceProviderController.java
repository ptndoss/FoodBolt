package edu.cloudtech.FoodBolt.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cloudtech.FoodBolt.dao.FoodList;
import edu.cloudtech.FoodBolt.dao.FoodListRepository;
import edu.cloudtech.FoodBolt.dao.RestaurantDay;
import edu.cloudtech.FoodBolt.dao.RestaurantTiming;
import edu.cloudtech.FoodBolt.dao.ServiceProvider;
import edu.cloudtech.FoodBolt.service.RestaurantTimingService;
import edu.cloudtech.FoodBolt.service.ServiceProviderService;

@RestController
@RequestMapping("/provider")
public class ServiceProviderController {
	
	@Autowired
	ServiceProviderService serviceproviderService;
	
	@RequestMapping(value = "/serviceProvider", method = RequestMethod.GET)
	public List getAllRestaurants() {
		
		System.out.println("In all Restaurant controller");
		System.out.println("Restaurant Details" + serviceproviderService.getAllServiceProviders());
		return serviceproviderService.getAllServiceProviders();
		
	}
	
	@RequestMapping(value = "/serviceProvider/{restaurant_id}", method = RequestMethod.GET)
	public ServiceProvider getRestaurant(@PathVariable int restaurant_id) {
		
		System.out.println("In all Restaurant controller");
		System.out.println("Restaurant Details" + serviceproviderService.getServiceProvider(restaurant_id));
		
		return serviceproviderService.getServiceProvider(restaurant_id);
		
	}
	
	
	@RequestMapping(value = "/addServiceProvider", method = RequestMethod.POST)
	public void addServiceProvider() {
	}
	
	@Autowired
	RestaurantTimingService restauranttimingService;
	
	@RequestMapping(value = "/restaurantTiming", method = RequestMethod.GET)
	public List getAllRestaurantTiming() {
		
		System.out.println("In all Restaurant controller");
		System.out.println("Restaurant Details" + restauranttimingService.getAllRestaurantTimings());
		return restauranttimingService.getAllRestaurantTimings();
				
		
	}
	
	@RequestMapping(value = "/addRestauTiming", method = RequestMethod.POST)
	public void addRestaurantTiming() {
		
		RestaurantTiming restTiming = new RestaurantTiming(); 
//		cust.setCust_id(15);		
		RestaurantDay restDay = new RestaurantDay();
		restDay.setRestaurant_id(2);
		restDay.setDay("TUESDAY");
		Date d = new Date();
		Calendar rightNow = Calendar.getInstance();
		System.out.println("Date From Calender" + rightNow.getTime() + " ");
		restTiming.setRestaurantDay(restDay);
		restTiming.setTiming_evening(rightNow.getTime());
		restTiming.setTiming_morning(rightNow.getTime());
		restTiming.setTiming_noon(rightNow.getTime());
	
		
		restauranttimingService.addRestaurantTiming(restTiming);
				
		
	}	
	
	@RequestMapping(value = "/restaurantTimeByDay", method = RequestMethod.GET)
	public RestaurantTiming getRestaurantTime() {
		
		
		RestaurantDay restDay= new RestaurantDay();
		restDay.setRestaurant_id(2);
		restDay.setDay("MONDAY");
		
		return  restauranttimingService.getRestaurantTimings(restDay);
	}
	
	
//	
//	@RequestMapping(value = "/reserveTable", method = RequestMethod.POST)
//	public String reserveTable(@RequestBody FoodList foodList) {
//		System.out.println(foodList.getRestaurant_id());
//		System.out.println(foodList.getCategory());
//		foodListRepository.addFoodList(foodList);
//		return "Food added successfully";
//	}
	
	
	
//	@RequestMapping(value = "/findTable", method = RequestMethod.POST)
//	public String findTable(@PathVariable int restaurant_id,@PathVariable ) {
//		System.out.println(foodList.getRestaurant_id());
//		System.out.println(foodList.getCategory());
//		foodListRepository.addFoodList(foodList);
//		return "Food added successfully";
//	}
//	
	
	
	
	
	
	
	
	
	
	@Autowired 
	public FoodListRepository foodListRepository;
	
	
	@RequestMapping(value = "/addFoodList", method = RequestMethod.POST)
	public String addFoodList(@RequestBody FoodList foodList) {
		System.out.println(foodList.getRestaurant_id());
		System.out.println(foodList.getCategory());
		foodListRepository.addFoodList(foodList);
		return "Food added successfully";
	}
	
	@RequestMapping(value = "/getFoodList/{restaurant_id}", method = RequestMethod.GET)
	public FoodList getFoodList(@PathVariable("restaurant_id") int restaurant_id) {
		
		return foodListRepository.getFoodList(restaurant_id);
//		return "Food added successfully";
	}
	
	
	
	@RequestMapping(value = "/deleteFoodList/{restaurant_id}", method = RequestMethod.DELETE)
	public String deleteFoodList(@PathVariable("restaurant_id") String restaurant_id) {
		
		FoodList foodlist = new FoodList();
		foodlist.setRestaurant_id(restaurant_id);
		foodListRepository.deleteFoodList(foodlist);
		return "Food Deleted successfully";
	}
	
	
	
	@RequestMapping(value = "/updateFoodList/{restaurant_id}", method = RequestMethod.PUT)
	public String updateFoodList(@PathVariable("restaurant_id") String restaurant_id) {
		
		FoodList foodlist = new FoodList();
		foodlist.setRestaurant_id(restaurant_id);
		foodListRepository.updateFoodList(foodlist);
		return "Food Updated successfully";
	}
	
	

}
