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
	
	public Page<Storelocation> getStorelocations(Pageable pageable, Long storeId) {
		Page<Storelocation> storelocations;
		storelocations = storelocationRepository.findByStoreId(pageable, storeId);
		
		return storelocations;
	}

	public Page<Storelocation> getStorelocations(Pageable pageable, Long storeId, Long shelf) {
		Page<Storelocation> storelocations;
		storelocations = storelocationRepository.findByStoreIdAndShelf(pageable, storeId, shelf);
		
		return storelocations;
	}
}
