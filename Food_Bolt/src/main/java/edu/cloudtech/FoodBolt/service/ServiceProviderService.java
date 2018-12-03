package edu.cloudtech.FoodBolt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cloudtech.FoodBolt.dao.ServiceProvider;
import edu.cloudtech.FoodBolt.dao.ServiceProviderDAO;

@Service
public class ServiceProviderService {

	@Autowired
	ServiceProviderDAO serviceproviderDAO;
	
	//Getting all Service Provider details.
	public List<ServiceProvider> getAllServiceProviders() {
		
		return serviceproviderDAO.findAll();
	}
	
	//Getting Service provider with restaurant ID
	public ServiceProvider getServiceProvider(long restaurant_id) {
		
		return serviceproviderDAO.findById(restaurant_id).orElse(null);
	}
	
	//Adding Service Provider details
	public void addServiceProviders(ServiceProvider serviceprovider) {
		serviceproviderDAO.save(serviceprovider);
	}
	
	
}
