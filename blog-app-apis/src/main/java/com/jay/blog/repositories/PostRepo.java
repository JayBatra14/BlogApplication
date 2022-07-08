package com.jay.blog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jay.blog.entities.Category;
import com.jay.blog.entities.Post;
import com.jay.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);
	
	@Modifying
	@Transactional
	@Query(value="delete from comments where post_id =:id", nativeQuery = true)
	public void deleteAllCommentsFromPost(@Param("id") Integer postId);
	
	@Modifying
	@Transactional
	@Query(value="delete from posts where post_id =:id", nativeQuery = true)
	public void deletePost(@Param("id") Integer postId);
}
