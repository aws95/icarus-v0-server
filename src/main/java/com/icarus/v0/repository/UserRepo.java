package com.icarus.v0.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icarus.v0.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
