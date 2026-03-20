package com.example.Zomato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemName;
    private double price;
    private String category;
    private boolean available;
    private int restaurantId;

    
    public Menu(int id, String itemName, double price, String category, boolean available, int restaurantId) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.available = available;
        this.restaurantId = restaurantId;
    }
    
    public Menu() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public int getRestaurantID() {
        return restaurantId;
    }
    public void setRestaurantID(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    

}
