package edu.cloudtech.FoodBolt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.CustomerDetailsDAO;

@Service
public class CustomerDetailsService {

	@Autowired
	private CustomerDetailsDAO customerdetailsDAO;
	
	public List getAllCustomers() {
		
		List customerDetails = new ArrayList<>();
		customerdetailsDAO.findAll().forEach(customerDetails::add);
		return customerDetails;
		
	}
	
	
	public CustomerDetails getCustomerDetails(int cust_id) {
		
		System.out.println("Cust Id" + cust_id);
//		List<CustomerDetails> cust = customerdetailsDAO.findById(cust_id);
		
//		Optional<CustomerDetails> optCustomerDetails = customerdetailsDAO.findById(cust_id).orElse(null);
//		System.out.println("In Service Class" + optCustomerDetails);
//		CustomerDetails customerDetails = optCustomerDetails.get();
		return customerdetailsDAO.findById(cust_id).orElse(null);
		
	}
	

	public void addCustomerDetails(CustomerDetails custdetails) {
		customerdetailsDAO.save(custdetails);
	}
	
	
}
