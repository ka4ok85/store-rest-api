package com.example.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = -6563858662417580716L;
	private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final Long storeId;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Long isAdmin;

    public JwtUser(Long id, String username, String firstName, String lastName, String password, Long storeId, Collection<? extends GrantedAuthority> authorities, boolean enabled, Long isAdmin) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.storeId = storeId;
        this.authorities = authorities;
        this.enabled = enabled;
        this.isAdmin = isAdmin;
    }
	
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

    @Override
    public String getPassword() {
        return password;
    }

    public Long getStoreId() {
        return storeId;
    }

	public Long getIsAdmin() {
		return isAdmin;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

	@Override
	public String toString() {
		return "JwtUser [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", storeId=" + storeId + ", authorities=" + authorities + ", enabled="
				+ enabled + ", isAdmin=" + isAdmin + "]";
	}

    
}
