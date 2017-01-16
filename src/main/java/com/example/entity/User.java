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
@Table(name="users")
public class User {

    @JsonView(com.example.entity.User.class)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonView(com.example.entity.User.class)
    @Column(name = "login", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String login;
    
    @JsonView(com.example.entity.User.class)
    @Column(name = "first_name", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String firstName;
    
    @JsonView(com.example.entity.User.class)
    @Column(name = "last_name", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String lastName;
    
    @JsonIgnore
    @Column(name = "password", unique = false, nullable = false, length = 255)
    @NotNull
    @NotEmpty
    @Size(max=255)
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="user_id")
    private Set<Userstore> userstores = new HashSet<Userstore>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Userstore> getUserstores() {
		return userstores;
	}

	public void setUserstores(Set<Userstore> userstores) {
		this.userstores = userstores;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}
    
    
}
