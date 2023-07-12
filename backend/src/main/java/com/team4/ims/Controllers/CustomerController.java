package com.team4.ims.Controllers;

import com.team4.ims.DTOs.Inventory.shoeDTO.AddShoeRequest;
import com.team4.ims.Services.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    /**
     * TODO: Implement CustomerController:
     * 1. Shoes of a specific color brand and size (Still under discussion)
     * 2. Purchase shoes and update the stock
     */



    @PostMapping("order")
    public ResponseEntity purchaseShoe(@RequestBody AddShoeRequest addShoeRequest){
        return customerService.placeOrder(addShoeRequest);
    }

}
