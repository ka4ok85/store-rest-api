package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Productlocation;
import com.example.repository.ProductlocationRepository;

@Service
public class ProductlocationService {
	@Autowired
	private ProductlocationRepository productlocationRepository;
	
	public Page<Productlocation> getProductlocations(Pageable pageable, Long productId) {
		Page<Productlocation> productlocations;
		productlocations = productlocationRepository.findByProductId(pageable, productId);
		
		return productlocations;
	}

}
