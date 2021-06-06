package com.icarus.v0.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "user" })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Username is mandatory")
	@Column(name = "username")
	private String username;
	
	@NotBlank(message = "User password is mandatory")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "User account status is mandatory")
	@Column(name = "active")
	private boolean active;
	
	@NotBlank(message = "User role is mandatory")
	@Column(name = "roles")
	private String roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
	}

	public User(int id, @NotBlank(message = "Username is mandatory") String username,
			@NotBlank(message = "User password is mandatory") String password,
			@NotBlank(message = "User account status is mandatory") boolean active,
			@NotBlank(message = "User role is mandatory") String roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public User() {
	}

}
