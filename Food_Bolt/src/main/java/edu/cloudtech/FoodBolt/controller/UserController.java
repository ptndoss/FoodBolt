package edu.cloudtech.FoodBolt.controller;

import edu.cloudtech.FoodBolt.exception.ResourceNotFoundException;
import edu.cloudtech.FoodBolt.model.User;
import edu.cloudtech.FoodBolt.repository.UserRepository;
import edu.cloudtech.FoodBolt.security.CurrentUser;
import edu.cloudtech.FoodBolt.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
