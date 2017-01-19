package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Productlocation;

public interface ProductlocationRepository extends PagingAndSortingRepository<Productlocation, Long> {

	Page<Productlocation> findByProductId(Pageable pageable, Long productId);

}
