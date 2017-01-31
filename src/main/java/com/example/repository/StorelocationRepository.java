package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Storelocation;

public interface StorelocationRepository extends PagingAndSortingRepository<Storelocation, Long>{
	Page<Storelocation> findByStoreId(Pageable pageable, Long StoreId);
	Page<Storelocation> findByStoreIdAndShelf(Pageable pageable, Long storeId, Long shelf);
	
	@Query("SELECT sl FROM Storelocation sl, Productlocation pl WHERE sl.id = pl.storeLocationId AND sl.storeId = :storeId AND pl.productId IS NULL")
	Page<Storelocation> findIsAvailableByStoreId(Pageable pageable, @Param("storeId") Long storeId);

	@Query("SELECT sl FROM Storelocation sl, Productlocation pl WHERE sl.id = pl.storeLocationId AND sl.storeId = :storeId AND pl.productId IS NOT NULL")
	Page<Storelocation> findIsNotAvailableByStoreId(Pageable pageable, @Param("storeId") Long storeId);
	
	Storelocation findByIdAndStoreId(Long storeLocationId, Long storeId);	
}
