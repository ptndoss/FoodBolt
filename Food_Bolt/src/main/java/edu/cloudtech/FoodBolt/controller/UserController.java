package edu.cloudtech.FoodBolt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.CustomerDetailsDAO;
import edu.cloudtech.FoodBolt.dao.ServiceProviderDAO;
import edu.cloudtech.FoodBolt.exception.ResourceNotFoundException;
import edu.cloudtech.FoodBolt.security.CurrentUser;
import edu.cloudtech.FoodBolt.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private CustomerDetailsDAO customerDetailsDAO;

    @Autowired
    private ServiceProviderDAO serviceProviderDAO;

    
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public CustomerDetails getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return customerDetailsDAO.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

/*    
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")    
    public ServiceProvider getCurrentServiceProvider(@CurrentUser UserPrincipal userPrincipal) {
        return serviceProviderDAO.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    } 
    
*/
    
}
