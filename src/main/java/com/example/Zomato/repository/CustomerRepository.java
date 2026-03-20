package com.example.Zomato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zomato.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);

}
