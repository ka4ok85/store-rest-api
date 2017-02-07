package com.example.dto.productlocation;

import com.example.entity.Product;
import com.example.entity.Productlocation;
import com.example.entity.Storelocation;
import com.fasterxml.jackson.annotation.JsonView;

public class ProductlocationWithProductAndStorelocationWrapper {

	@JsonView(com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper.class)
	private Long id;

	@JsonView(com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper.class)
	private Product product;
	
	@JsonView(com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper.class)
	private Long storeId;

	@JsonView(com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper.class)
	private Storelocation storelocation;
	
	@JsonView(com.example.dto.productlocation.ProductlocationWithProductAndStorelocationWrapper.class)
	private Long quantity;

	public ProductlocationWithProductAndStorelocationWrapper(Productlocation productlocation, Product product, Storelocation storelocation) {
		super();
		this.id = productlocation.getId();
		this.quantity = productlocation.getQuantity();
		this.storeId = productlocation.getStoreId();
		this.product = product;
		this.storelocation = storelocation;
	}


}
