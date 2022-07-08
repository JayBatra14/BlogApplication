package com.jay.blog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jay.blog.config.AppConstants;
import com.jay.blog.exceptions.ApiResponse;
import com.jay.blog.payloads.PostDto;
import com.jay.blog.payloads.PostResponse;
import com.jay.blog.services.FileService;
import com.jay.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts/")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId){
		return new ResponseEntity<PostDto>(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts/")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable("userId") Integer userId){
		return new ResponseEntity<List<PostDto>>(postService.getPostsByUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts/")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("categoryId") Integer categoryId){
		return new ResponseEntity<List<PostDto>>(postService.getPostsByCategory(categoryId), HttpStatus.OK);
	}
	
	@GetMapping("/posts/")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value="pageNumber", defaultValue=AppConstants.PAGE_NUMBER , required=false) Integer pageNumber,
			@RequestParam(value="pageSize", defaultValue=AppConstants.PAGE_SIZE , required=false) Integer pageSize,
			@RequestParam(value="sortBy", defaultValue=AppConstants.SORT_BY, required=false) String sortBy,
			@RequestParam(value="sortDir", defaultValue=AppConstants.SORT_DIR , required=false) String sortDir){
		return new ResponseEntity<PostResponse>(postService.getAllPosts(pageNumber,pageSize,sortBy,sortDir), HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable("postId") Integer postId){
		return new ResponseEntity<PostDto>(postService.getPost(postId), HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") Integer postId){
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post is deleted successfully !!", true), HttpStatus.OK);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("postId") Integer postId){
		return new ResponseEntity<PostDto>(postService.updatePost(postDto, postId), HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
		return new ResponseEntity<List<PostDto>>(postService.searchPosts(keywords), HttpStatus.OK);
	}
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,
			@PathVariable("postId") Integer postId) throws IOException {
		
		PostDto postDto = postService.getPost(postId);
		String fileName = fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		return new ResponseEntity<PostDto>(postService.updatePost(postDto, postId), HttpStatus.OK);
	}
	
	@GetMapping(value="/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
		
		InputStream resource = fileService.getSource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
		
	}
}
