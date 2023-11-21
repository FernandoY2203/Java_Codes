package com.cursojava.project2_WebServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.project2_WebServices.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
