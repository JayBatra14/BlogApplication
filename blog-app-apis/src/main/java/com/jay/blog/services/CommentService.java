package com.jay.blog.services;

import com.jay.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
	
	void deleteComment(Integer commentId);
	
}
