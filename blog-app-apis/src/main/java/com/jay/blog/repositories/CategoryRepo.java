package com.jay.blog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jay.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	@Modifying
	@Transactional
	@Query(value="delete from posts where category_id =:id", nativeQuery = true)
	public void deleteAllPosts(@Param("id") Integer categoryId);
	
	@Modifying
	@Transactional
	@Query(value="delete from categories where category_id =:id", nativeQuery = true)
	public void deleteCategory(@Param("id") Integer categoryId);
	
}
