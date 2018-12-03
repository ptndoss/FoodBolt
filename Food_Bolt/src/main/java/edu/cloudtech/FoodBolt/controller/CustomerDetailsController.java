package edu.cloudtech.FoodBolt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.service.CustomerDetailsService;


@RestController
@RequestMapping("/users")
public class CustomerDetailsController {

	
	@Autowired
	CustomerDetailsService customerDetailService;
	
	@RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
	public List getAllCustomers() {
		
		System.out.println("In All Customer controller");
		System.out.println("CUstomer Details" + customerDetailService.getAllCustomers());
		return customerDetailService.getAllCustomers();
		
	}
	
	@RequestMapping(value = "/customerDetails/{cust_id}", method = RequestMethod.GET)
	public CustomerDetails getCustomer(@PathVariable long cust_id) {
		
		CustomerDetails cust = customerDetailService.getCustomerDetails(cust_id);
		System.out.println("In Customer controller with Cust ID " + cust_id);
		System.out.println("CUST ID FROM DB " + cust.getCust_id());
		
		return customerDetailService.getCustomerDetails(cust_id);
		
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public void addCustomer() {
		
		CustomerDetails cust = new CustomerDetails(); 
//		cust.setCust_id(15);		
		cust.setFirst_name("Thiru");
//		cust.setMiddle_name("Nambi");
		cust.setEmail("email1@gmail.com");
		cust.setCity("city");
		cust.setLast_name("Doss");
		cust.setPassword("ABCD");
		
//		customerDetailService.getCustomerDetails(cust_id);
//		System.out.println("In Customer controller with Cust ID " + cust_id);
//		System.out.println("CUST ID FROM DB " + cust.getCust_id());
		
		customerDetailService.addCustomerDetails(cust);
		
	}
	
	
	
	
	
}
