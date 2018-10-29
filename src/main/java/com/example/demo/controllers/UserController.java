package com.example.demo.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.domain.User;
import com.example.demo.core.service.UserService;

@RestController
public class UserController {
	
	  @Autowired
	  private UserService userService;
	  
	
	@RequestMapping("/user")
	  public Principal user(Principal principal) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	     if (authentication == null) {
	    	 return null;
	     }
	     
		 // This Details object exposes a token that allows us to interact with Facebook on this user's behalf
	    String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
	      

	 
	    Facebook fbApi = new FacebookTemplate(token);
	    org.springframework.social.facebook.api.User fbUser = fbApi.fetchObject("me", org.springframework.social.facebook.api.User.class, "first_name", "last_name", "email");
	    
	   User user = userService.getByFacebookId(fbUser.getId());
	    
	   if (user == null) {
		   
	    user = new User();
	     // Use the spring-social-facebook classes to request the user data we need
	    
	    user.setFirstName(fbUser.getFirstName());
	    user.setLastName(fbUser.getLastName());
	    user.setEmail(fbUser.getEmail());
	    user.setFacebookId(fbUser.getId());
	      
	    // Set the default Roles for users registered via Facebook
	      //user.setRoles(Sets.newHashSet(Role.ROLE_USER, Role.ROLE_USER_FACEBOOK));
	      //user = userService.saveUser(user);
	      userService.saveUser(user);
	   }
	    return principal;
	  

}
	
}
