package com.example.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Store;
import com.example.entity.Storelocation;
import com.example.service.v1.StoreService;
import com.example.service.v1.StorelocationService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("StorelocationControllerV1")
@RequestMapping("/v1/")
@io.swagger.annotations.Api(value = "storelocations", description = "Storelocation API", tags = "storelocations")
public class StorelocationController {

	@Autowired
	private StorelocationService storelocationService;
	
	@RequestMapping(value = "/storelocations", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Storelocations for Store", notes = "Retrieves Storeloctions for Store using sort and page/size parameters", response = Storelocation.class, responseContainer = "Page")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List of Storelocations for Store", responseContainer = "List", response = Storelocation.class)
	})
	public ResponseEntity<Page<Storelocation>> getStorelocations(@RequestParam(value = "available", required = false) Boolean isAvailable, @RequestParam(value = "shelf", required = false) Long shelf, Pageable pageable) {
		//****HARDCODED*****/
		Long storeId = 3L;
		Page<Storelocation> storelocations = storelocationService.getStorelocations(pageable, storeId);
		
		return new ResponseEntity<>(storelocations, HttpStatus.OK);
	}
	


}