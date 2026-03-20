package com.example.Zomato.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private int id;
    private int customerId;
    private String customerName;
    private List<Integer> itemIds;
    private Double totalAmount;
    private LocalDateTime orderedAt;
    private String status;
    
    public OrderDTO(int id, int customerId, String customerName, List<Integer> itemIds, Double totalAmount,
            LocalDateTime orderedAt) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
        this.orderedAt = orderedAt;
    }

    public OrderDTO() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public List<Integer> getItemIds() {
        return itemIds;
    }
    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }
    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    

}
