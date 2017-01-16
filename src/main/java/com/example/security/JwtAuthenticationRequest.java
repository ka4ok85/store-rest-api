package com.example.security;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

	private static final long serialVersionUID = -3415246546391732983L;

	private String username;
    private String password;
    private Long storeId;

    public JwtAuthenticationRequest(String username, String password, Long storeId) {
		this.username = username;
		this.password = password;
		this.storeId = storeId;
	}

	public JwtAuthenticationRequest() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequest [username=" + username + ", password=" + password + ", storeId=" + storeId
				+ "]";
	}
    
}
