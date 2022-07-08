package com.jay.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jay.blog.entities.User;
import com.jay.blog.exceptions.ResourceNotFoundException;
import com.jay.blog.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email : "+username, 0));
		return user;
	}

}
