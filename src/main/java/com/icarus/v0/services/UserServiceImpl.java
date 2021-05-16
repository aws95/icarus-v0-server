package com.icarus.v0.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icarus.v0.entities.User;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public Object createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		return userRepo.findById(id).map(u -> {
			u.setUsername(user.getUsername());
			u.setActive(user.isActive());
			u.setRoles(user.getRoles());
			u.setPassword(user.getPassword());
			return userRepo.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("User ID " + id + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteUser(Long id) {
		return userRepo.findById(id).map(user -> {
			userRepo.delete(user);
			return ResponseEntity.ok().body("User with ID " + id + "was deleted");
		}).orElseThrow(() -> new ResourceNotFoundException("User ID " + id + " not found"));
	}

	@Override
	public User listUser(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User ID " + id + " not found"));
	}

	@Override
	public List<User> listUsers() {
		return (List<User>) userRepo.findAll();
	}

}
