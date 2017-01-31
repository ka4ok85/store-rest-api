package com.example.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.entity.Store;
import com.example.entity.Storelocation;
import com.example.exception.ResourceNotFoundException;
import com.example.security.UserDetailsServiceImplementation;
import com.example.service.v1.ProductService;
import com.example.service.v1.StoreService;
import com.example.service.v1.StorelocationService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("StorelocationControllerV1")
@RequestMapping("/v1/")
@io.swagger.annotations.Api(value = "storelocations", description = "Storelocation API", tags = "storelocations")
public class StorelocationController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private StorelocationService storelocationService;

    @Autowired
    private UserDetailsServiceImplementation userDetailsService;

	@RequestMapping(value = "/storelocations", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Storelocations for Store", notes = "Retrieves Storeloctions for Store using sort and page/size parameters", response = Storelocation.class, responseContainer = "Page")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List of Storelocations for Store", responseContainer = "List", response = Storelocation.class)
	})
	public ResponseEntity<Page<Storelocation>> getStorelocations(@RequestParam(value = "available", required = false) Boolean isAvailable, @RequestParam(value = "shelf", required = false) Long shelf, Pageable pageable) {

		Long storeId = userDetailsService.getStoreId();
		Page<Storelocation> storelocations;
		if (shelf == null) {
			if (isAvailable == null) {
				// return all
				storelocations = storelocationService.getStorelocations(pageable, storeId);
			} else {
				storelocations = storelocationService.getStorelocations(pageable, storeId, isAvailable);
			}
		} else {
			// return only for selected shelf
			storelocations = storelocationService.getStorelocations(pageable, storeId, shelf);
		}

		return new ResponseEntity<>(storelocations, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/storelocations/{storeLocationId}", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Storelocation within Store", notes = "Retrieves Storelocation within Store.", response = Storelocation.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns Storelocation for Store", response = String.class)
	})
	public ResponseEntity<Storelocation> getStorelocation(@PathVariable(value = "storeLocationId", required = true) Long storeLocationId) {
		Long storeId = userDetailsService.getStoreId();
		Storelocation storelocation;
		
		storelocation = storelocationService.getStorelocation(storeLocationId, storeId);
		if (storelocation == null) {
			throw new ResourceNotFoundException("Storelocation with ID = " + storeLocationId + " not found");
		} else {
			return new ResponseEntity<>(storelocation, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/storelocations/{storeLocationId}/products", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves List of Storelocation's Products within Store", notes = "Retrieves List of Storelocation's Products within Store.", response = Product.class, responseContainer = "Page")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List of Storelocation's Products for Store", responseContainer = "List", response = Product.class)
	})
	public ResponseEntity<Page<Product>> getStorelocationProducts(@PathVariable(value = "storeLocationId", required = true) Long storeLocationId, Pageable pageable) {
		Long storeId = userDetailsService.getStoreId();
		Page<Product> products;
		
		products = productService.getProductsByStoreIdAndStoreLocationId(pageable, storeLocationId, storeId);
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		/*
		Storelocation storelocation;
		
		storelocation = storelocationService.getStorelocation(storeLocationId, storeId);
		if (storelocation == null) {
			throw new ResourceNotFoundException("Storelocation with ID = " + storeLocationId + " not found");
		} else {
			return new ResponseEntity<>(storelocation, HttpStatus.OK);
		}
		*/
	}
	
	@RequestMapping(value = "/storelocations/{storeLocationId}", method = RequestMethod.DELETE)
	@io.swagger.annotations.ApiOperation(value = "Removes Storelocation within Store", notes = "Removes Storelocation within Store. Allowed only for users with Admin privileges. Storelocation must be empty", response = String.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Storelocation deleted", response = String.class)
	})
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> deleteStorelocation(@PathVariable(value = "storeLocationId", required = true) Long storeLocationId) {
		Long storeId = userDetailsService.getStoreId();

		//TODO: implementation
		return new ResponseEntity<>(null, HttpStatus.OK);
	}	



}
