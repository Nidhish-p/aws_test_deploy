package com.example.Zomato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zomato.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findById(int restaurantId);
    List<Restaurant> findByAddress(String address);
}
