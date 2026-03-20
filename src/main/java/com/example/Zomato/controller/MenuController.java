package com.example.Zomato.controller;

import com.example.Zomato.entity.*;
import com.example.Zomato.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.Zomato.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Menu> addItem(@PathVariable int restaurantId, @RequestBody Menu item) {
        Menu saved = menuService.addMenuItem(restaurantId, item);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Menu>> getMenuByRestaurant(@PathVariable int restaurantId) {
        return ResponseEntity.ok(menuService.getMenuByRestaurant(restaurantId));
    }

    @GetMapping("/restaurant/{restaurantId}/available")
    public ResponseEntity<List<Menu>> getAvailableMenu(@PathVariable int restaurantId) {
        return ResponseEntity.ok(menuService.getAvailableMenu(restaurantId));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Menu> getItemById(@PathVariable int itemId) {
        return ResponseEntity.ok(menuService.getMenuItemById(itemId));
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Menu> updateItem(@PathVariable int itemId, @RequestBody Menu item) {
        return ResponseEntity.ok(menuService.updateMenuItem(itemId, item));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable int itemId) {
        menuService.deleteMenuItem(itemId);
        return ResponseEntity.ok("Menu item deleted");
    }

}
