package com.example.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	/*
	public Page<Product> getProducts(Pageable pageable, String name) {
		Page<Product> stores;
		if (name == null) {
			stores = productRepository.findAll(pageable);			
		} else {
			stores = productRepository.findByName(pageable, name);
		}
		
		return stores;
	}
	*/
	
	public Product findOne(Long storeId) {
		return productRepository.findOne(storeId);
	}

	public Page<Product> getProductsByStoreIdAndStoreLocationId(Pageable pageable, Long storeLocationId, Long storeId) {
		Page<Product> products;
		products = productRepository.findByStoreIdAndStoreLocationId(pageable, storeId, storeLocationId);
		
		return products;
	}
}
