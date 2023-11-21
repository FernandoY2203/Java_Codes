package com.cursojava.project2_WebServices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.project2_WebServices.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
}
