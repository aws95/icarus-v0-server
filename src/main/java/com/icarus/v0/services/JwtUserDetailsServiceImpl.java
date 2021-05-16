package com.icarus.v0.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icarus.v0.entities.IcarusUserDetails;
import com.icarus.v0.entities.User;
import com.icarus.v0.repository.UserRepo;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	

    @Autowired
    UserRepo userRepo;
    
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUsername(username);
		 user.orElseThrow(() -> new UsernameNotFoundException(username + "Not found: " ));
		 return user.map(IcarusUserDetails::new).get();
	}
}
