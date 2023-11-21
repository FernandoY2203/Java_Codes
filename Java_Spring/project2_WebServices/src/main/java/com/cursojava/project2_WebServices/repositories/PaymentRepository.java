package com.cursojava.project2_WebServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.project2_WebServices.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
