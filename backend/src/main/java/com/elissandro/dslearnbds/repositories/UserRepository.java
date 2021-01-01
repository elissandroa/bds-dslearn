package com.elissandro.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elissandro.dslearnbds.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
}
