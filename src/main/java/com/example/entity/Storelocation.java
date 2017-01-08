package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="store_locations")
public class Storelocation {

	@JsonView(com.example.entity.Storelocation.class)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonView(com.example.entity.Storelocation.class)
	@Column(name = "store_id", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	private Long storeId;
	
	@JsonView(com.example.entity.Storelocation.class)
	@Column(name = "shelf", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	private Long shelf;
	
	@JsonView(com.example.entity.Storelocation.class)
	@Column(name = "slot", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	private Long slot;
	
	@JsonView(com.example.entity.Storelocation.class)
	@Column(name = "barcode", unique = false, nullable = false, length = 255)
	@NotNull
	@NotEmpty
	@Size(max=30)
	private String barcode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getShelf() {
		return shelf;
	}

	public void setShelf(Long shelf) {
		this.shelf = shelf;
	}

	public Long getSlot() {
		return slot;
	}

	public void setSlot(Long slot) {
		this.slot = slot;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Storelocation [id=" + id + ", storeId=" + storeId + ", shelf=" + shelf + ", slot=" + slot + ", barcode="
				+ barcode + "]";
	}
	
	
}
