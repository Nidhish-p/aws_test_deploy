package com.example.Zomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zomato.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
