package com.example.Zomato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Zomato.entity.Menu;
import com.example.Zomato.repository.MenuRepository;
import com.example.Zomato.repository.RestaurantRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepo;

    @Autowired
    private RestaurantRepository restaurantRepo;

    public Menu addMenuItem(int restaurantId, Menu item) {
        item.setRestaurantID(restaurantId);
        return menuRepo.save(item);
    }

    public List<Menu> getMenuByRestaurant(int restaurantId) {
        return menuRepo.findByRestaurantId(restaurantId);
    }

    public List<Menu> getAvailableMenu(int restaurantId) {
        return menuRepo.findByRestaurantIdAndAvailableTrue(restaurantId);
    }

    public Menu getMenuItemById(int itemId) {
        return menuRepo.findById(itemId)
                .orElseThrow(() -> new RuntimeException("item:"+itemId+" not found"));
    }

    public Menu updateMenuItem(int itemId, Menu updated) {
        Menu item = getMenuItemById(itemId);
        item.setItemName(updated.getItemName());
        item.setPrice(updated.getPrice());
        item.setCategory(updated.getCategory());
        item.setAvailable(updated.isAvailable());
        return menuRepo.save(item);
    }

    public void deleteMenuItem(int itemId) {
        Menu item = getMenuItemById(itemId);
        menuRepo.delete(item);
    }

}
