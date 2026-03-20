package com.example.Zomato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Zomato.dto.CustomerDTO;
import com.example.Zomato.dto.LoginDTO;
import com.example.Zomato.entity.Customer;
import com.example.Zomato.entity.User;
import com.example.Zomato.repository.CustomerRepository;
import com.example.Zomato.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private UserRepository userRepo;


    public CustomerDTO registerCustomer(CustomerDTO dto) {

        if (customerRepo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered: " + dto.getEmail());
        }
    
        Customer c = new Customer();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setPhone(dto.getPhone());
        c.setAddress(dto.getAddress());
    
        Customer saved = customerRepo.save(c);
    
        User u = new User();
        u.setUsername(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getEmail() + "@123");
    
        userRepo.save(u);
    
        dto.setId(saved.getId());
        return dto;
    }

    public String login(LoginDTO loginDTO) {

        User u = userRepo.findByEmail(loginDTO.getEmail());

        if (!u.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful for: " + u.getEmail();
    }

}
