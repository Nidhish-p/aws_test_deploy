package com.example.Zomato.service;

import com.example.Zomato.dto.*;
import com.example.Zomato.entity.*;
import com.example.Zomato.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private MenuRepository menuRepo;

    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Customer customer = customerRepo.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer"+orderDTO.getCustomerId()));

        List<Menu> selectedItems = menuRepo.findAllById(orderDTO.getItemIds());
        if (selectedItems.isEmpty()) {
            throw new RuntimeException("No valid menu items found for given IDs");
        }

        double total = selectedItems.stream()
                .mapToDouble(Menu::getPrice)
                .sum();

        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(selectedItems);
        order.setAmount(total);
        order.setStatus("placed");

        Order saved = orderRepo.save(order);
        return mapToDTO(saved);
    }

    public List<OrderDTO> getOrdersByCustomer(int customerId) {
        customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer"+ customerId));

        return orderRepo.findByCustomerId(customerId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(int orderId) {
        Order o = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order"+ orderId));
        return mapToDTO(o);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO updateOrderStatus(int orderId, String status) {
        Order o = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order"+ orderId));

        return mapToDTO(orderRepo.save(o));
    }

    private OrderDTO mapToDTO(Order o) {
        OrderDTO dto = new OrderDTO();
        dto.setId(o.getId());
        dto.setCustomerId(o.getCustomer().getId());
        dto.setCustomerName(o.getCustomer().getName());
        dto.setTotalAmount(o.getAmount());
        dto.setStatus(o.getStatus());
        dto.setOrderedAt(o.getOrderTime());

        List<Integer> ids = o.getItems().stream()
                .map(Menu::getId)
                .collect(Collectors.toList());
        dto.setItemIds(ids);

        return dto;
    }

}
