package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Storelocation;

public interface StorelocationRepository extends PagingAndSortingRepository<Storelocation, Long>{
	Page<Storelocation> findByStoreId(Pageable pageable, Long StoreId);

}
