package com.team4.ims.Services;


import com.team4.ims.Models.Shoe;
import com.team4.ims.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    //Todo: Implement CustomerService:
    /**
     * 1. Shoes of a specific color brand and size (Still under discussion)
     * 2. Purchase shoes and update the stock
     * */
    @Autowired
    private final CustomerRepository customerRepository;

    public ResponseEntity<List<Shoe>> getCustomerShoes(){
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
