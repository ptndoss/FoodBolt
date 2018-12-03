package edu.cloudtech.FoodBolt.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.CustomerDetailsDAO;
import edu.cloudtech.FoodBolt.dao.ServiceProvider;
import edu.cloudtech.FoodBolt.dao.ServiceProviderDAO;
import edu.cloudtech.FoodBolt.exception.ResourceNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerDetailsDAO customerDetailsDAO;

    @Autowired
    ServiceProviderDAO serviceProviderDAO;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {  
    	
    	if (customerDetailsDAO.existsByEmail(email)) {
    		CustomerDetails customer = customerDetailsDAO.findByEmail(email)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found with email : " + email)
            );

            return UserPrincipal.create(customer);
    		
    	} else {
    		ServiceProvider serviceProvider = serviceProviderDAO.findByEmail(email)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found with email : " + email)
            );

            return UserPrincipal.create(serviceProvider);
    		
    	}
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
    	
    	if (id < 1000000) {
    		CustomerDetails customer = customerDetailsDAO.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	        );
	
	        return UserPrincipal.create(customer);
    		
    	} else {
    		ServiceProvider serviceProvider = serviceProviderDAO.findById(id).orElseThrow(
	                () -> new ResourceNotFoundException("User", "id", id)
	            );
	
	            return UserPrincipal.create(serviceProvider);
	    }
    }
}