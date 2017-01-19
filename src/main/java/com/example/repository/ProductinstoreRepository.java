package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Productinstore;

public interface ProductinstoreRepository extends PagingAndSortingRepository<Productinstore, Long> {

	Productinstore findByProductId(Long productId);

}
