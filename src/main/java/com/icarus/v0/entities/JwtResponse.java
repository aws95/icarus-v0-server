package com.icarus.v0.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {

	private final String jwttoken;
	private final String name;
	private final List<GrantedAuthority> authorities;

	public JwtResponse(String jwttoken, String name, List<GrantedAuthority> authorities) {
		this.jwttoken = jwttoken;
		this.name = name;
		this.authorities = authorities;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public String getName() {
		return name;
	}

	public List<GrantedAuthority> getRole() {
		return authorities;
	}
}
