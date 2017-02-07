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

import com.example.entity.Storelocation;
import com.example.entity.Product;
import com.example.security.UserDetailsServiceImplementation;
import com.example.service.v1.ProductService;
import com.example.service.v1.StorelocationService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("ProductControllerV1")
@RequestMapping("/v1/")
@io.swagger.annotations.Api(value = "products", description = "Product API", tags = "products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private StorelocationService storelocationService;

    @Autowired
    private UserDetailsServiceImplementation userDetailsService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@io.swagger.annotations.ApiOperation(value = "Retrieves Products for Store", notes = "Retrieves Products for Store using sort and page/size parameters", response = Product.class, responseContainer = "Page")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List of Products for Store", responseContainer = "List", response = Product.class)
	})
	public ResponseEntity<Page<Product>> getProducts(@RequestParam(value = "alreadyInStore", required = false) Boolean isAlreadyInStore, Pageable pageable) {

		Long storeId = userDetailsService.getStoreId();
		Page<Product> products;
		if (isAlreadyInStore == null || isAlreadyInStore == true) {
			products = productService.getProductsByStoreId(pageable, storeId);
		} else {
			products = productService.getProductsNotInStore(pageable, storeId);
		}

		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	
	//getProductsByStoreId
}
