package com.example.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.error.ErrorDetail;
import com.example.entity.Store;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StoreRepository;
import com.example.service.v1.StoreService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController("StoreControllerV1")
@RequestMapping("/v1/")
@io.swagger.annotations.Api(value = "stores", description = "Store API", tags = "stores")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Stores", notes = "Retrieves Stores using sort and page/size parameters", response = Store.class, responseContainer = "Page")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List of Stores", responseContainer = "List", response = Store.class)
	})
	public ResponseEntity<Page<Store>> getStores(@RequestParam(value = "name", required = false) String name, Pageable pageable) {
		Page<Store> stores = storeService.getStores(pageable, name);
		
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}
	
/*
	@RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Single Store", notes = "Retrieves Singe Store using ID", response = Store.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns Store", response = Store.class),
		    @ApiResponse(code = 401, message = "Unauthorized"),
		    @ApiResponse(code = 403, message = "Forbidden"),
		    @ApiResponse(code = 404, message = "Store not found", response = ErrorDetail.class)
	})
	public ResponseEntity<Store> getStore(@PathVariable Long storeId) {
		Store store = storeRepository.findOne(storeId);
		if (store == null) {
			throw new ResourceNotFoundException("Store with ID = " + storeId + " not found");
		}
		
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
	*/
}
