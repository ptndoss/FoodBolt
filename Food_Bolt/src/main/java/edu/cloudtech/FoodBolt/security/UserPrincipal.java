package edu.cloudtech.FoodBolt.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.ServiceProvider;

@SuppressWarnings("serial")
public class UserPrincipal implements OAuth2User, UserDetails {
    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(CustomerDetails customer) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
        		customer.getCust_id(),
        		customer.getEmail(),
        		customer.getPassword(),
                authorities
        );
    }

    public static UserPrincipal create(CustomerDetails customer, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(customer);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    
    public static UserPrincipal create(ServiceProvider serviceProvider) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
        		serviceProvider.getRestaurant_id(),
        		serviceProvider.getEmail(),
        		serviceProvider.getPassword(),
                authorities
        );
    }
    
    public static UserPrincipal create(ServiceProvider serviceProvider, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(serviceProvider);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }
    
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }
}
