package com.proj3.project3_WebServicesNoSQL.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proj3.project3_WebServicesNoSQL.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
