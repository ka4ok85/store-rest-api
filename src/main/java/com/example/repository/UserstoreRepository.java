package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.UserStatus;
import com.example.entity.Userstore;

public interface UserstoreRepository extends PagingAndSortingRepository<Userstore, Long> {

	Userstore findByUserIdAndStoreIdAndStatus(Long userId, Long storeId, UserStatus userStatus);

}
