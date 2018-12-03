package edu.cloudtech.FoodBolt.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.CustomerDetailsDAO;
import edu.cloudtech.FoodBolt.dao.ServiceProvider;
import edu.cloudtech.FoodBolt.dao.ServiceProviderDAO;
import edu.cloudtech.FoodBolt.exception.BadRequestException;
import edu.cloudtech.FoodBolt.dao.AuthProvider;
import edu.cloudtech.FoodBolt.security.TokenProvider;
import edu.cloudtech.FoodBolt.service.ApiResponse;
import edu.cloudtech.FoodBolt.service.AuthResponse;
import edu.cloudtech.FoodBolt.service.LoginRequest;
import edu.cloudtech.FoodBolt.service.SignUpRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailsDAO customerDetailsDAO;

    @Autowired
    private ServiceProviderDAO serviceProviderDAO;
        
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

    	long currentServiceProviderCount = serviceProviderDAO.count();
        System.out.println("Before adding cust count = " + customerDetailsDAO.count());
        System.out.println("Before adding rest count = " + serviceProviderDAO.count());        
        
        
        if (signUpRequest.getSignupRole().contains("Customer") == true) {
        	
            if(customerDetailsDAO.existsByEmail(signUpRequest.getEmail())) {
                throw new BadRequestException("Customer Email address already in use.");
            }

            CustomerDetails customer = new CustomerDetails();
            
            customer.setSignupRole(signUpRequest.getSignupRole());        	
            customer.setFirst_name(signUpRequest.getFirstName());
            customer.setLast_name(signUpRequest.getLastName());
            customer.setDefault_guests(signUpRequest.getGuests());
            customer.setCuisine(signUpRequest.getCuisine());
            customer.setEmail(signUpRequest.getEmail());
            customer.setPassword(signUpRequest.getPassword());
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));            
            customer.setProvider(AuthProvider.local);
            customer.setCity(signUpRequest.getCity());
            customer.setState(signUpRequest.getState());
            
            CustomerDetails result = customerDetailsDAO.save(customer);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/user/me")
                    .buildAndExpand(result.getCust_id()).toUri();

            System.out.println("After adding cust count = " + customerDetailsDAO.count());
            
            return ResponseEntity.created(location)
                    .body(new ApiResponse(true, "Customer registered successfully@"));
            
        } else {
        	
            if(serviceProviderDAO.existsByEmail(signUpRequest.getEmail())) {
                throw new BadRequestException("ServiceProvider Email address already in use.");
            }

            
            ServiceProvider serviceProvider = new ServiceProvider();
            
            serviceProvider.setSignupRole(signUpRequest.getSignupRole());
            serviceProvider.setName(signUpRequest.getName());
            serviceProvider.setTotalTables(signUpRequest.getTotalTables());
            serviceProvider.setTotalOccupancy(signUpRequest.getTotalOccupancy());            
            serviceProvider.setCuisine(signUpRequest.getCuisine());
            serviceProvider.setEmail(signUpRequest.getEmail());
            serviceProvider.setPassword(signUpRequest.getPassword());
            serviceProvider.setProvider(AuthProvider.local);
            serviceProvider.setPassword(passwordEncoder.encode(serviceProvider.getPassword()));
            serviceProvider.setCity(signUpRequest.getCity());
            serviceProvider.setState(signUpRequest.getState());
            serviceProvider.setRestaurant_id(currentServiceProviderCount + 1000001);
            
        	ServiceProvider result = serviceProviderDAO.save(serviceProvider);
            
            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/user/me")
                    .buildAndExpand(result.getRestaurant_id()).toUri();

            System.out.println("After adding rest count = " + serviceProviderDAO.count());
            
            return ResponseEntity.created(location)
                    .body(new ApiResponse(true, "ServiceProvider registered successfully"));
            
        }
                
        
    }

}
