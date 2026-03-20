package com.example.Zomato.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "order_menu",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> items;

    private Double Amount;

    private String status;
    private LocalDateTime orderTime;
    
    public Order(int id, Customer customer, List<Menu> items, Double amount, String status, LocalDateTime orderTime) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.Amount = amount;
        this.status = status;
        this.orderTime = orderTime;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<Menu> getItems() {
        return items;
    }
    public void setItems(List<Menu> items) {
        this.items = items;
    }
    public Double getAmount() {
        return Amount;
    }
    public void setAmount(Double amount) {
        Amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    
}
