package com.jay.blog.payloads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer userId;
	
	@NotEmpty
	@Size(min = 4, message="Username must be minimum of 4 characters !!")
	private String name;
	
	@Email(message= "Email address is not valid !!")
	//@Pattern(regexp="")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max=64, message="Password must be minimum of 3 and maximum of 10 characters !!")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<CommentDto> comments = new HashSet<>();
	
	private Set<RoleDto> roles = new HashSet<>();
	
	//private List<PostDto> posts = new ArrayList<>();
	
}
