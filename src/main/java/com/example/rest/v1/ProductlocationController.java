package com.example.rest.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper;
import com.example.entity.Product;
import com.example.entity.Productlocation;
import com.example.entity.Storelocation;
import com.example.security.UserDetailsServiceImplementation;
import com.example.service.v1.ProductlocationService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("ProductlocationControllerV1")
@RequestMapping("/v1/")
@io.swagger.annotations.Api(value = "productlocations", description = "Productlocation API", tags = "productlocations")
public class ProductlocationController {

	@Autowired
	private ProductlocationService productlocationService;
	
    @Autowired
    private UserDetailsServiceImplementation userDetailsService;

	@RequestMapping(value = "/productlocations", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Productlocations for Store", notes = "Retrieves Productloctions for Store by List of IDs", response = Productlocation.class, responseContainer = "List")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List of Productlocations for Store", responseContainer = "List", response = Productlocation.class)
	})
	public ResponseEntity<List<ProductlocationWithProductAndStorelocationWrapper>> getProductlocations(@RequestParam(value = "storelocationid", required = false) String idList, Pageable pageable) {

		Long storeId = userDetailsService.getStoreId();
		List<ProductlocationWithProductAndStorelocationWrapper> productlocations;
		if (idList == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			// return only for provided List of IDs
			List<Long> ids = new ArrayList<Long>();
			for (String s : idList.split(",")) {
				ids.add(Long.parseLong(s));
			}
			
			productlocations = productlocationService.findByStoreIdAndStorelocationId(storeId, ids);
		}

		return new ResponseEntity<>(productlocations, HttpStatus.OK);
	}
}
