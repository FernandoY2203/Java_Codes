package com.cursojava.project2_WebServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.project2_WebServices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
