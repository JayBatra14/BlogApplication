package com.jay.blog.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// 1. Get Token
		
		String requestToken = request.getHeader("Authorization");
		
		// Bearer 123456789 
		
		System.out.println(requestToken);
		
		String username = null;
		
		String token = null;
		
		if(requestToken!=null && requestToken.startsWith("Bearer")) {
			token = requestToken.substring(7);
			try {
				username = jwtTokenHelper.getUsernameFromToken(token);
			} catch(IllegalArgumentException e) {
				//throw new ApiException("Unable to get JWT Token !!");
				System.out.println("Unable to get JWT Token !!");
			} catch(ExpiredJwtException e) {
				//throw new ApiException("JWT Token has expired !!");
				System.out.println("JWT Token has expired !!");
			} catch(MalformedJwtException e) {
				//throw new ApiException("Invalid JWT Token !!");
				System.out.println("Invalid JWT Token !!");
			}
		}
		else {
			//throw new ApiException("Jwt token doesn't begin with Bearer !!");
			System.out.println("Jwt token doesn't begin with Bearer !!");
		}
		
		// Once we get the token, now we will validate it
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			if(jwtTokenHelper.validateToken(token, userDetails)) {
				// It's working fine
				// Now we have to do authentication
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				//throw new ApiException("Invalid JWT Token !!");
				System.out.println("Invalid JWT Token !!");
			}
		}else {
			//throw new ApiException("Username is null or context is not null !!");
			System.out.println("Username is null or context is not null !!");
		}
		filterChain.doFilter(request, response);
	}

}
