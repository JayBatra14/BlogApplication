package com.jay.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jay.blog.config.AppConstants;
import com.jay.blog.entities.Role;
import com.jay.blog.entities.User;
import com.jay.blog.exceptions.ApiException;
import com.jay.blog.exceptions.ResourceNotFoundException;
import com.jay.blog.payloads.RoleDto;
import com.jay.blog.payloads.UserDto;
import com.jay.blog.repositories.RoleRepo;
import com.jay.blog.repositories.UserRepo;
import com.jay.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	// CREATE USER
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = dtoToUser(userDto);
		User savedUser = userRepo.save(user);
		return userToDto(savedUser);
	}

	// UPDATE USER
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDto.getName());
		//user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		Set<RoleDto> roleDtos = userDto.getRoles();
		Set<Role> newRoles = roleDtos.stream().map((role) -> modelMapper.map(role, Role.class)).collect(Collectors.toSet());
		Set<Role> oldRoles = user.getRoles();
		oldRoles.addAll(newRoles);
		user.setRoles(oldRoles);
		//user.setPassword(userDto.getPassword());
		User updateUser = userRepo.save(user);
		return userToDto(updateUser);
	}

	// GET USER
	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		return userToDto(user);
	}

	// GET ALL USERS
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	// DELETE USER
	@Override
	public void deleteUser(Integer userId) {
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		userRepo.deleteUserRole(userId);
		userRepo.deleteAllCommentsByUser(userId);
		userRepo.deleteAllPostsByUser(userId);
		userRepo.deleteUser(userId);
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
//		user.setUserId(userDto.getUserId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		
		Optional<User> findByEmail = userRepo.findByEmail(userDto.getEmail());
		
		if(findByEmail.isPresent()) {
			throw new ApiException("User with this email id already exists please try another email id !!");
		}
		
		User user = modelMapper.map(userDto, User.class);
		
		// Encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// Roles
		Role role = roleRepo.findById(AppConstants.ROLE_NORMAL).get();
		
		user.getRoles().add(role);
		
		return modelMapper.map(userRepo.save(user), UserDto.class);
		
	}
	
	

}
