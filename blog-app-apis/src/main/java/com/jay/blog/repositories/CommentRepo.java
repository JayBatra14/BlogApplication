package com.jay.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
