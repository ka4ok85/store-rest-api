package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedAttributeNode;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="products")
@NamedEntityGraphs({
    @NamedEntityGraph(
        name = "basicProduct",
        includeAllAttributes=false,
        attributeNodes = {
            @NamedAttributeNode("name"),
            @NamedAttributeNode("quantity")
        }
    ),
    @NamedEntityGraph(
        name = "fullProduct",
        attributeNodes = {
            @NamedAttributeNode(value = "productinstores", subgraph = "basicProduct")
        }
    )
})
public class Product {
    @JsonView(com.example.entity.Product.class)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonView(com.example.entity.Product.class)
    @Column(name = "sku", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String sku;

    @JsonView(com.example.entity.Product.class)
    @Column(name = "name", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String name;
    
    @JsonView(com.example.entity.Product.class)
    @Column(name = "quantity", unique = false, nullable = false)
    @NotNull
    private Long quantity;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName="id")
    @JsonIgnore
    private Set<Productinstore> productinstores = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName="id")
    @JsonIgnore
    private Set<Productlocation> productlocations = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Set<Productinstore> getProductinstores() {
		return productinstores;
	}

	public void setProductinstores(Set<Productinstore> productinstores) {
		this.productinstores = productinstores;
	}

	public Set<Productlocation> getProductlocations() {
		return productlocations;
	}

	public void setProductlocations(Set<Productlocation> productlocations) {
		this.productlocations = productlocations;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", quantity=" + quantity + "]";
	}
    
    
}
