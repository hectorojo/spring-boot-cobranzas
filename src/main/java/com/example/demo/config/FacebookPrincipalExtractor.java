/*package com.example.demo.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.core.domain.User;
import com.example.demo.core.service.UserService;

import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Component
public class FacebookPrincipalExtractor implements PrincipalExtractor {
	
  @Autowired
  private UserService userService;
  
  @Override
  public Object extractPrincipal(Map<String, Object> map) {
    String id = (String) map.get("id");
    
// Check if we've already registered this user
 User user = userService.getByFacebookId(id); 
 if (user == null) {
// If we haven't registered this user yet, create a new one   
	 
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     if (authentication == null) {
    	 return null;
     }
     
	 // This Details object exposes a token that allows us to interact with Facebook on this user's behalf
    String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
      
    user = new User();
     // Use the spring-social-facebook classes to request the user data we need
 
    Facebook fbApi = new FacebookTemplate(token);
    org.springframework.social.facebook.api.User fbUser = fbApi.fetchObject("me", org.springframework.social.facebook.api.User.class, "first_name", "last_name", "email");
    
    user.setFirstName(fbUser.getFirstName());
    user.setLastName(fbUser.getLastName());
    user.setEmail(fbUser.getEmail());
      
    // Set the default Roles for users registered via Facebook
      //user.setRoles(Sets.newHashSet(Role.ROLE_USER, Role.ROLE_USER_FACEBOOK));
      //user = userService.saveUser(user);
      userService.saveUser(user);
   }
    return user;
     // return null;
  }

  }
*/