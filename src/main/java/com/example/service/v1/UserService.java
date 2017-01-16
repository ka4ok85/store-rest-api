package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findOne(Long userId) {
		return userRepository.findOne(userId);
	}

	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
	
}
