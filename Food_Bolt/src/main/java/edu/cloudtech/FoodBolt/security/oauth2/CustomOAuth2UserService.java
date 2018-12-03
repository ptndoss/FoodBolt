package edu.cloudtech.FoodBolt.security.oauth2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import edu.cloudtech.FoodBolt.dao.AuthProvider;
import edu.cloudtech.FoodBolt.dao.CustomerDetails;
import edu.cloudtech.FoodBolt.dao.CustomerDetailsDAO;
import edu.cloudtech.FoodBolt.exception.OAuth2AuthenticationProcessingException;
import edu.cloudtech.FoodBolt.security.UserPrincipal;
import edu.cloudtech.FoodBolt.security.oauth2.user.OAuth2UserInfo;
import edu.cloudtech.FoodBolt.security.oauth2.user.OAuth2UserInfoFactory;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private CustomerDetailsDAO customerDetailsDAO;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<CustomerDetails> userOptional = customerDetailsDAO.findByEmail(oAuth2UserInfo.getEmail());
        CustomerDetails customer;
        if(userOptional.isPresent()) {
        	customer = userOptional.get();
            if(!customer.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                		customer.getProvider() + " account. Please use your " + customer.getProvider() +
                        " account to login.");
            }
            customer = updateExistingUser(customer, oAuth2UserInfo);
        } else {
        	customer = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(customer, oAuth2User.getAttributes());
    }

    private CustomerDetails registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
    	    	
    	CustomerDetails customer = new CustomerDetails();

    	customer.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
    	customer.setFirst_name(oAuth2UserInfo.getFirstName());
    	customer.setLast_name(oAuth2UserInfo.getLastName());        	
    	customer.setEmail(oAuth2UserInfo.getEmail());
    	customer.setImageUrl(oAuth2UserInfo.getImageUrl());
    	customer.setSignupRole("");        
    	customer.setCity("");
    	customer.setState("");
    	customer.setCuisine("");
    	customer.setDefault_guests(0);
        
        return customerDetailsDAO.save(customer);
        
    }

    private CustomerDetails updateExistingUser(CustomerDetails existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setFirst_name(oAuth2UserInfo.getFirstName());
        existingUser.setLast_name(oAuth2UserInfo.getLastName());        	        
        existingUser.setImageUrl(oAuth2UserInfo.getImageUrl());
        return customerDetailsDAO.save(existingUser);
    }

}
