package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserStatus;
import com.example.entity.Userstore;
import com.example.repository.UserstoreRepository;

@Service
public class UserstoreService {
	
	@Autowired
	UserstoreRepository userstoreRepository;

	public Userstore findByUserIdAndStoreIdAndStatus(Long userId, Long storeId, UserStatus userStatus) {
		return userstoreRepository.findByUserIdAndStoreIdAndStatus(userId, storeId, userStatus);
	}
	
	

}
