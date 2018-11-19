package edu.cloudtech.FoodBolt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.ServiceProvider;
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
		
		ServiceProvider serv_provider = new ServiceProvider(); 
		
		serv_provider.setRestaurant_name("ABC Hotel");
		serv_provider.setEmail("abc3@gmail.com");
		serv_provider.setCity("SanJose");
		serv_provider.setCuisine_typ("veg");
		serv_provider.setState("CA");
		serv_provider.setTotal_tables(10);
		serv_provider.setTotal_occupancy(100);
		serv_provider.setIs_active("YES");
		
		serviceproviderService.addServiceProviders(serv_provider);
		
	}
	
	
	
	

}
