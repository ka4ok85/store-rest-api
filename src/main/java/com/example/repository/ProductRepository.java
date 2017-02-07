package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{

	@Query("SELECT p FROM Product p, Storelocation sl, Productlocation pl WHERE p.id = pl.productId AND sl.id = pl.storeLocationId AND sl.storeId = :storeId AND sl.id = :storeLocationId")
	Page<Product> findByStoreIdAndStoreLocationId(Pageable pageable, @Param("storeId") Long storeId, @Param("storeLocationId") Long storeLocationId);
	
	@Query("SELECT DISTINCT p FROM Product p, Productinstore ps WHERE p.id=ps.productId and ps.storeId = :storeId")
	Page<Product> findAllProductsInStore(Pageable pageable, @Param("storeId") Long store);
	
	@Query("SELECT DISTINCT p FROM Product p WHERE p.id NOT IN (SELECT ps.productId FROM Productinstore ps WHERE ps.storeId = :storeId) ")
	Page<Product> findAllProductsNotInStore(Pageable pageable, @Param("storeId") Long store);

}