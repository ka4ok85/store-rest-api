package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="stores")
public class Store {


    @JsonView(com.example.entity.Store.class)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonView(com.example.entity.Store.class)
    @Column(name = "name", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String name;

    @JsonView(com.example.entity.Store.class)
    @Column(name = "address", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String address;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="store_id")
    private Set<Storelocation> storelocations = new HashSet<Storelocation>();

	public Store() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Storelocation> getStorelocations() {
		return storelocations;
	}

	public void setStorelocations(Set<Storelocation> storelocations) {
		this.storelocations = storelocations;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

    
}
