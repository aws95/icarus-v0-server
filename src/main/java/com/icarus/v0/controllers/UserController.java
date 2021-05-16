package com.icarus.v0.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarus.v0.entities.User;
import com.icarus.v0.services.UserServiceImpl;

@RestController
@RequestMapping({"api/v1/users/"})
public class UserController {
	@Autowired
	   UserServiceImpl userService;
	
	@PostMapping("add")
	public Object createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("{id}")
	public User updateUser(@PathVariable Long id,@Valid @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@GetMapping("{id}")
	public User listUser(@PathVariable Long id) {
		return userService.listUser(id);
	}

	@GetMapping("list")
	public List<User> listUsers() {
		return (List<User>) userService.listUsers();
	}
}
