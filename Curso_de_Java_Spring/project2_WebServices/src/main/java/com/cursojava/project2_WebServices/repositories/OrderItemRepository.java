package com.cursojava.project2_WebServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.project2_WebServices.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
