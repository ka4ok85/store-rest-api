package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Productinstore;
import com.example.repository.ProductinstoreRepository;;

@Service
public class ProductinstoreService {
	@Autowired
	private ProductinstoreRepository productinstoreRepository;
	
	public Productinstore getProductinstore(Long productId) {
		Productinstore productinstore = productinstoreRepository.findByProductId(productId);
		
		return productinstore;
	}
}
