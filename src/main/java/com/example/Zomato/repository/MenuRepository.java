package com.example.Zomato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Zomato.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findByRestaurantId(int restaurantId);
    List<Menu> findByRestaurantIdAndAvailableTrue(int restaurantId);
}
