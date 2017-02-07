package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper;
import com.example.entity.Productlocation;


public interface ProductlocationRepository extends PagingAndSortingRepository<Productlocation, Long> {

	Page<Productlocation> findByProductId(Pageable pageable, Long productId);
	List<Productlocation> findByIdIn(List<Long> idList);
	
	@Query("SELECT new com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper(pl, p, sl) FROM Product p, Storelocation sl, Productlocation pl WHERE p.id = pl.productId AND sl.id = pl.storeLocationId AND sl.storeId = :storeId AND sl.id IN :ids")
	List<ProductlocationWithProductAndStorelocationWrapper> findByStoreIdAndStorelocationId(@Param("storeId") Long storeId, @Param("ids") List<Long> storeLocationIdList);
}
