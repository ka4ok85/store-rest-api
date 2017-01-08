package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Storelocation;
import com.example.repository.StorelocationRepository;

@Service
public class StorelocationService {
	@Autowired
	private StorelocationRepository storelocationRepository;
	
	public Page<Storelocation> getStorelocations(Pageable pageable, Long StoreId) {
		Page<Storelocation> storelocations;
		storelocations = storelocationRepository.findByStoreId(pageable, StoreId);
		
		return storelocations;
	}
}
