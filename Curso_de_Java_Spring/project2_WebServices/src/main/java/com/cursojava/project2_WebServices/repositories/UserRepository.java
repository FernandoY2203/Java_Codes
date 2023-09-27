package com.cursojava.project2_WebServices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.project2_WebServices.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);
}
