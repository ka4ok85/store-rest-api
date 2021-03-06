package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Store;


public interface StoreRepository extends PagingAndSortingRepository<Store, Long>{
	Page<Store> findByName(Pageable pageable, String name);
}
