package com.example.Zomato.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    
    @OneToMany
    private List<Menu> menu;

    
    public Restaurant(int id, String name, String address, String phone, List<Menu> menu) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.menu = menu;
    }

    public Restaurant() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Menu> getMenu() {
        return menu;
    }
    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
    
    
}
