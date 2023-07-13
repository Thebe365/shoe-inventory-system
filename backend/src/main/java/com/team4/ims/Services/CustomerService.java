package com.team4.ims.Services;


import com.team4.ims.DTOs.Inventory.shoeDTO.AddShoeRequest;
import com.team4.ims.DTOs.Inventory.shoeDTO.ShoeOrder;
import com.team4.ims.Models.Inventory;
import com.team4.ims.Models.Sales;
import com.team4.ims.Models.Shoe;
import com.team4.ims.Repository.CustomerRepository;
import com.team4.ims.Repository.InventoryRepository;
import com.team4.ims.Repository.ShoeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    //Todo: Implement CustomerService:
    /**
     * 1. Shoes of a specific color brand and size (Still under discussion)
     * 2. Purchase shoes and update the stock
     */
    @Autowired
    private final CustomerRepository customerRepository;
    private final InventoryRepository inventoryRepository;
    private final ShoeRepository shoeRepository;



    //Makes an order
    public ResponseEntity<String> placeOrder(AddShoeRequest addShoe) {
        for (ShoeOrder shoe : addShoe.getShoes()) {
            Optional<Shoe> shoeCheck = shoeRepository.findByName(shoe.getShoeName());
            if (!shoeCheck.isPresent()) {
                return ResponseEntity.badRequest().body("Shoe does not exist");
            }

            // Place order logic here
            /**
             *fetches all inventory items with the same shoe name
             */
            //fetchs all inventory items with the same shoe name
            List<Inventory> inventory = inventoryRepository
                    .findAllByShoe(shoeCheck.get());

            Optional<Inventory> unit = inventoryRepository.findInventoryByColorAndSizeAndShoe(shoe.getShoeColor(), shoe.getShoeSize(), shoeCheck.get());
            System.out.println("unit: "+unit);

            if(unit.isPresent()){

                System.out.println("Shoe found in inventory");
                unit.get().setQuantity(unit.get().getQuantity() - shoe.getQuantity());
                inventoryRepository.save(unit.get());

                Sales sale = Sales.builder()
                        .date(new Date())
                        .inventoryId(unit.get())
                        .totalPrice(unit.get().getPrice()*shoe.getQuantity())
                        .quantity(shoe.getQuantity())
                        .build();
                customerRepository.save(sale);

            } else{
                 return ResponseEntity.badRequest().body("Shoe not found in inventory");
            }
        }

        return ResponseEntity.ok("Order updated");
    }
}