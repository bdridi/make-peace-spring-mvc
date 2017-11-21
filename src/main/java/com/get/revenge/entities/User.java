package com.get.revenge.entities;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="STS_USERS")
public class User {
	
	@Id
	@NotEmpty
	private String username; 
	@NotEmpty
	private String name; 
	@NotEmpty
	private String email; 
	@NotEmpty
	private String password;
	@Column
	private String role = "ROLE_USER";

	public User() {
	}
	
	public User(String username, String name, String email, String password) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = "ROLE_USER";
	}
	
	
	
	public String getUsername() {
		return username;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setusername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() { 
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
