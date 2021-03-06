package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="product_in_stores")
public class Productinstore {
	
	@JsonView(com.example.entity.Productinstore.class)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonView(com.example.entity.Productinstore.class)
	@Column(name = "product_id", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	private Long productId;
	
	@JsonView(com.example.entity.Productinstore.class)
	@Column(name = "store_id", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	private Long storeId;

	@JsonView(com.example.entity.Productinstore.class)
	@Column(name = "quantity", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	private Long quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Productinstore [id=" + id + ", productId=" + productId + ", storeId=" + storeId + ", quantity="
				+ quantity + "]";
	}
	
	
}
