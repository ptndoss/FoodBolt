package edu.cloudtech.FoodBolt.controller;

import edu.cloudtech.FoodBolt.exception.BadRequestException;
import edu.cloudtech.FoodBolt.model.AuthProvider;
import edu.cloudtech.FoodBolt.model.User;
import edu.cloudtech.FoodBolt.service.ApiResponse;
import edu.cloudtech.FoodBolt.service.AuthResponse;
import edu.cloudtech.FoodBolt.service.LoginRequest;
import edu.cloudtech.FoodBolt.service.SignUpRequest;
import edu.cloudtech.FoodBolt.repository.UserRepository;
import edu.cloudtech.FoodBolt.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

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
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        User user = new User();
        user.setSignupRole(signUpRequest.getSignupRole());
        if (user.getSignupRole().contains("Customer") == true) {
        	user.setFirstName(signUpRequest.getFirstName());
            user.setLastName(signUpRequest.getLastName());
            user.setName(user.getFirstName() + " " + user.getLastName());            
            user.setGuests(signUpRequest.getGuests());
            user.setTotalTables(0);
            user.setTotalOccupancy(0);
        } else {
            user.setName(signUpRequest.getName());
            user.setTotalTables(signUpRequest.getTotalTables());
        	user.setTotalOccupancy(signUpRequest.getTotalOccupancy());
            user.setFirstName("");
            user.setLastName("");
            user.setGuests(0);
        }
        user.setCuisine(signUpRequest.getCuisine());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCity(signUpRequest.getCity());
        user.setState(signUpRequest.getState());

        User result = userRepository.save(user);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}
