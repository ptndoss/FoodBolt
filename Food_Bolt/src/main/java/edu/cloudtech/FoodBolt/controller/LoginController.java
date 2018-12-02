package edu.cloudtech.FoodBolt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class LoginController {
	
	
	/*@PostMapping("/login")
	public String login(@ModelAttribute(name="customerDetails") CustomerDetails customerDetails, Model model,  HttpSession session) {
		
		String Username = customerDetails.getEmail();
		String Password = customerDetails.getPassword();
		String DB_Username = "";
		String DB_Password = "";
		String First_Name ="";
		String Middle_Name ="";
		String Last_Name ="";
		String IsAdmin="";
		String SELECT_SQL = "SELECT * FROM User where Email = ?";
		
		session.setAttribute("isLoggedIn", true);
		session.setAttribute("email", Username);

		User user = null;
		try {
			 user = jdbcTemplate.queryForObject(SELECT_SQL, new UserRowMapper(), loginform.getUsername());
		} catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		if(user == null) {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "UserNotAvailable");
			return "Login";
		}
		DB_Username =user.getEmail();
		DB_Password =user.getPassword();
		First_Name=user.getFirst_Name();
		Middle_Name=user.getMiddle_Name();
		Last_Name=user.getLast_Name();
		IsAdmin=user.getIsAdmin();
		session.setAttribute("firstName", First_Name);
		session.setAttribute("middleName", Middle_Name);
		session.setAttribute("lastName", Last_Name);
		session.setAttribute("IsAdmin", IsAdmin);
		System.out.println("LogIn Admin??????????" + IsAdmin);
		
		if(IsAdmin.equals("YES")) {
			if(DB_Username.equals(Username) && DB_Password.equals(Password) ) {
				this.amazonClient.listAllObjects(model);
				return "adminList";
			}
			return "adminList";
		}
		else if(DB_Username.isEmpty() || DB_Username == null) {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "UserNotAvailable");
			return "Login";
		}
		else if(DB_Username.equals(Username) && DB_Password.equals(Password)) {
			this.amazonClient.listObjects(model);
			return "list";
		}
		else {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "InvalidCredential");
			return "Login";
		}
			
	}*/

	
	

}
