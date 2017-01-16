package com.example.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.StoreRestApiApplication;
import com.example.entity.User;
import com.example.entity.UserStatus;
import com.example.entity.Userstore;
import com.example.service.v1.UserService;
import com.example.service.v1.UserstoreService;

@Service("userDetailsService")
public class UserDetailsServiceImplementation implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(StoreRestApiApplication.class);
	
	private Long userId;
	private Long storeId;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserstoreService userstoreService;
	
	@Override
	public JwtUser loadUserByUsername(String login) throws UsernameNotFoundException {

		User user = userService.findByLogin(login);
		if (user == null) {
			log.info("UserDetailsServiceImplementation can not find such login {}.", login);
        	
            throw new UsernameNotFoundException(String.format("No user found with login '%s'.", login));
		} else {
			Userstore userstore = userstoreService.findByUserIdAndStoreIdAndStatus(user.getId(), storeId, UserStatus.active);
			if (userstore == null) {
				log.info("UserDetailsServiceImplementation can not find such active login: {}.", login);
	            throw new UsernameNotFoundException(String.format("No active user found with login '%s' in storeId=%s", login, storeId));
			} else {
				SimpleGrantedAuthority simpleGrantedAuthority;
				if (userstore.getIsAdmin().equals(1L)) {
					simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
				} else {
					simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
				}

				List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
	            grantedAuthorityList.add(simpleGrantedAuthority);
	            setUserId(user.getId());
				
	            JwtUser jwtUser = new JwtUser(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName(), user.getPassword(), storeId, grantedAuthorityList, true, userstore.getIsAdmin());
	            
	            return jwtUser;
			}
		} 
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	
	
}
