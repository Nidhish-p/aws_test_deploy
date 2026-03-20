package com.example.Zomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Zomato.entity.Restaurant;
import com.example.Zomato.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepo;

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantRepo.findById(id);
    }

    public List<Restaurant> getByAddress(String address) {
        return restaurantRepo.findByAddress(address);
    }

    public Restaurant updateRestaurant(int id, Restaurant updated) {
        Restaurant existing = getRestaurantById(id);
        existing.setName(updated.getName());
        existing.setAddress(updated.getAddress());
        existing.setPhone(updated.getPhone());
        return restaurantRepo.save(existing);
    }

    public void deleteRestaurant(int id) {
        Restaurant r = getRestaurantById(id);
        restaurantRepo.delete(r);
    }

}
