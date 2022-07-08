package com.jay.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.blog.entities.Comment;
import com.jay.blog.entities.Post;
import com.jay.blog.entities.User;
import com.jay.blog.exceptions.ResourceNotFoundException;
import com.jay.blog.payloads.CommentDto;
import com.jay.blog.repositories.CommentRepo;
import com.jay.blog.repositories.PostRepo;
import com.jay.blog.repositories.UserRepo;
import com.jay.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
 
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
		Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUserComment(user);
		return modelMapper.map(commentRepo.save(comment), CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment Id", commentId));
		commentRepo.delete(comment);
	}

}
