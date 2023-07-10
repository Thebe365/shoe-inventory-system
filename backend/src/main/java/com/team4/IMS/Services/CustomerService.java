package com.team4.ims.Services;


import com.team4.ims.Models.Shoe;
<<<<<<< HEAD:backend/src/main/java/com/team4/IMS/Services/CustomerService.java
import com.team4.ims.Repository.CustomerRepository;
=======
import com.team4.ims.repository.CustomerRepository;
>>>>>>> 813e024 (one commit on yourBranch):backend/src/main/java/com/team4/ims/Services/CustomerService.java
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
