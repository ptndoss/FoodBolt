package edu.cloudtech.FoodBolt.security.oauth2.user;

import edu.cloudtech.FoodBolt.exception.OAuth2AuthenticationProcessingException;
import edu.cloudtech.FoodBolt.model.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("This login with " + registrationId + " is not supported yet.");
        }
    }
}
