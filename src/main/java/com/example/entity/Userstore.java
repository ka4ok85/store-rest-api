package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="user_in_stores")
public class Userstore {

    @JsonView(com.example.entity.Userstore.class)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonView(com.example.entity.Userstore.class)
    @Column(name = "user_id", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    private Long userId;
    
    @JsonView(com.example.entity.Userstore.class)
    @Column(name = "store_id", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    private Long storeId;
    
    @JsonView(com.example.entity.Userstore.class)
    @Column(name = "status", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=8)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    
    @JsonView(com.example.entity.Userstore.class)
    @Column(name = "is_admin", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    private Long isAdmin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Long getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Long isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Userstore [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", status=" + status
				+ ", isAdmin=" + isAdmin + "]";
	}
    
    
}
