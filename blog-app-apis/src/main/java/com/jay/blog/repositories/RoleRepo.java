package com.jay.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
