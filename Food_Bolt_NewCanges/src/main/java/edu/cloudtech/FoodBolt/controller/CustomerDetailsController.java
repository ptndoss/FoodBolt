package edu.cloudtech.FoodBolt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.service.CustomerDetailsService;


@Controller
/*@RequestMapping("/users")*/
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
	public CustomerDetails getCustomer(@PathVariable int cust_id) {
		
		CustomerDetails cust = customerDetailService.getCustomerDetails(cust_id);
		System.out.println("In Customer controller with Cust ID " + cust_id);
		System.out.println("CUST ID FROM DB " + cust.getCust_id());
		
		return customerDetailService.getCustomerDetails(cust_id);
		
	}
	
	
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public String addCustomer(@ModelAttribute(name="CustomerDetails") CustomerDetails user, Model model,  HttpSession session) {
//		
//
//		customerDetailService.addCustomerDetails(user);
//		
//		return "signup";
//		
//	}
	
	@GetMapping("/Signup")
	public String signup() {
	System.out.println("Inside Get method ****");
//	Console.log("Inside get method");
		return "signup";
	}
	
	
	@RequestMapping(value = "/Signup", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute(name="CustomerDetails") CustomerDetails user, Model model,  HttpSession session) {
		
		System.out.println("In SIgnUp Controller" + user.getEmail());
		System.out.println("Default Guest" +  user.getDefault_guests());
		customerDetailService.addCustomerDetails(user);
		
		return "index";	
	}
	
	
	
	
	
}
