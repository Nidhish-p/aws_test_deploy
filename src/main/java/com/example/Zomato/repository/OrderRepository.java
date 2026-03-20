package com.example.Zomato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zomato.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int customerId);
    List<Order> findByStatus(String status);
}
