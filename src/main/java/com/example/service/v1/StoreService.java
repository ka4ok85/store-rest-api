package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Store;
import com.example.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;
	
	public Page<Store> getStores(Pageable pageable, String name) {
		Page<Store> stores;
		if (name == null) {
			stores = storeRepository.findAll(pageable);			
		} else {
			stores = storeRepository.findByName(pageable, name);
		}
		
		return stores;
	}
	
	public Store findOne(Long storeId) {
		return storeRepository.findOne(storeId);
	}
}
