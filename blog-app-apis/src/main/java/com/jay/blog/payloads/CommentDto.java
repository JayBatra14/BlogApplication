package com.jay.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private Integer id;
	
	@NotBlank
	@Size(min=4, message="Minimum size of comment is 4")
	private String content;
}
