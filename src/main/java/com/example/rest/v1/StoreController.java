package com.example.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Store;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StoreRepository;

@RestController("StoreControllerV1")
@RequestMapping("/v1/")
@io.swagger.annotations.Api(value = "stores", description = "Store API")
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;
	
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Stores", notes = "Retrieves Stores using sort and page/size parameters", response = Store.class, responseContainer = "Page")
	public ResponseEntity<Page<Store>> getStores(Pageable pageable) {
		Page<Store> stores = storeRepository.findAll(pageable);
		
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Single Store", notes = "Retrieves Singe Store using ID", response = Store.class)
	public ResponseEntity<Store> getStore(@PathVariable Long storeId) {
		Store store = storeRepository.findOne(storeId);
		if (store == null) {
			throw new ResourceNotFoundException("Store with ID = " + storeId + " not found");
		}
		
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
}
