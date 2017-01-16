package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.StoreRestApiApplication;
import com.example.entity.Store;
import com.example.entity.User;
import com.example.entity.UserStatus;
import com.example.entity.Userstore;
import com.example.service.v1.StoreService;
import com.example.service.v1.UserService;
import com.example.service.v1.UserstoreService;

public class CustomUserDetailsAuthenticationProvider extends DaoAuthenticationProvider {

	private static final Logger log = LoggerFactory.getLogger(StoreRestApiApplication.class);
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserstoreService userstoreService;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// let DaoAuthenticationProvider make it's checks first
		super.additionalAuthenticationChecks(userDetails, authentication);
		
		// now it's time for our custom Authentication Checks
		JwtAuthenticationRequest details = (JwtAuthenticationRequest) authentication.getDetails();
		log.info("JwtAuthenticationRequest is {}.", details);
		
		
		String login = details.getUsername();
		User user = userService.findByLogin(login);
        if (user == null) {
            throw new BadCredentialsException("Unknown Login: " + login);
        }

        Long storeId = details.getStoreId();
        Store store = storeService.findOne(storeId);
        if (store == null) {
            throw new BadCredentialsException("Unknown Store: " + storeId);
        }
        
      
        Userstore userstore = userstoreService.findByUserIdAndStoreIdAndStatus(user.getId(), store.getId(), UserStatus.active);
        if (userstore == null) {
            throw new BadCredentialsException("Can not find active user " + user.getLogin() + " for store id=" + store.getId());
        }
        
		log.info("Userstore is {}.", userstore);
	}

}
