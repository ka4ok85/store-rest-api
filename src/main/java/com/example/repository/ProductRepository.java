package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Product;
import com.example.entity.Storelocation;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{

	@Query("SELECT p FROM Product p, Storelocation sl, Productlocation pl WHERE p.id = pl.productId AND sl.id = pl.storeLocationId AND sl.storeId = :storeId AND sl.id = :storeLocationId")
	Page<Product> findByStoreIdAndStoreLocationId(Pageable pageable, @Param("storeId") Long storeId, @Param("storeLocationId") Long storeLocationId);
	
	//@Query("SELECT sl FROM Storelocation sl, Productlocation pl WHERE sl.id = pl.storeLocationId AND sl.storeId = :storeId AND pl.productId IS NOT NULL")
	//Page<Storelocation> findIsNotAvailableByStoreId(Pageable pageable, @Param("storeId") Long storeId);
	//Page<Store> findByName(Pageable pageable, String name);
}