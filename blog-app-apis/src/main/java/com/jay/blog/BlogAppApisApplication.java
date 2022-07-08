package com.jay.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jay.blog.config.AppConstants;
import com.jay.blog.entities.Role;
import com.jay.blog.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("abcd"));
		try {
			
			Role roleAdmin = new Role();
			roleAdmin.setRoleId(AppConstants.ROLE_ADMIN);
			roleAdmin.setName("ROLE_ADMIN");
			
			Role roleNormal = new Role();
			roleNormal.setRoleId(AppConstants.ROLE_NORMAL);
			roleNormal.setName("ROLE_NORMAL");
			
			List<Role> roles = List.of(roleAdmin, roleNormal);
			
			List<Role> result = roleRepo.saveAll(roles);
			
			result.forEach(r -> {
				System.out.println(r.getName());
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
