package com.jay.blog.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jay.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query(value="delete from user_role where user =:id", nativeQuery = true)
	public void deleteUserRole(@Param("id") Integer userId);
	
	@Modifying
	@Transactional
	@Query(value="delete from users where user_id =:id", nativeQuery = true)
	public void deleteUser(@Param("id") Integer userId);
	
	@Modifying
	@Transactional
	@Query(value="delete from comments where user_id =:id", nativeQuery = true)
	public void deleteAllCommentsByUser(@Param("id") Integer userId);
	
	@Modifying
	@Transactional
	@Query(value="delete from posts where user_id =:id", nativeQuery = true)
	public void deleteAllPostsByUser(@Param("id") Integer userId);
	
	
}
