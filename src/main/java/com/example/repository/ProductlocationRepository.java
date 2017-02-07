package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Productlocation;


public interface ProductlocationRepository extends PagingAndSortingRepository<Productlocation, Long> {

	Page<Productlocation> findByProductId(Pageable pageable, Long productId);
	List<Productlocation> findByIdIn(List<Long> idList);
}
