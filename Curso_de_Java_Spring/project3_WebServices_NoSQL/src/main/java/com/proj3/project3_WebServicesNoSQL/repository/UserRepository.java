package com.proj3.project3_WebServicesNoSQL.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proj3.project3_WebServicesNoSQL.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
}
