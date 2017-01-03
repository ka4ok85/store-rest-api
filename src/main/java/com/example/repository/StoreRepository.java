package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Store;

public interface StoreRepository extends PagingAndSortingRepository<Store, Long>{

}
