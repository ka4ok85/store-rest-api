package com.example.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Store;
import com.example.repository.StoreRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController("StoreControllerV1")
@RequestMapping("/v1/")
@Api(value = "stores", description = "Store API")
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;
	
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieves Stores", notes = "Retrieves Stores using sort and page/size parameters", response = Store.class, responseContainer = "Page")
	public ResponseEntity<Page<Store>> getStores(Pageable pageable) {
		Page<Store> stores = storeRepository.findAll(pageable);
		
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}
	

}
