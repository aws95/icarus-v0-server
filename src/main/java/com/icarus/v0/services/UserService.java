package com.icarus.v0.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icarus.v0.entities.User;

public interface UserService {
	
	
	public abstract Object createUser(User user);
	public abstract User updateUser(Long id, User user);
	public abstract ResponseEntity<?> deleteUser(Long id);
	public abstract User listUser(Long id);
	public abstract List<User> listUsers();
}
