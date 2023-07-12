package com.team4.ims.Services;


import com.team4.ims.DTOs.Inventory.shoeDTO.AddShoeRequest;
import com.team4.ims.DTOs.Inventory.shoeDTO.ShoeOrder;
import com.team4.ims.Models.Inventory;
import com.team4.ims.Models.Sales;
import com.team4.ims.Models.Shoe;
import com.team4.ims.repository.BrandRepository;
import com.team4.ims.repository.CustomerRepository;
import com.team4.ims.repository.InventoryRepository;
import com.team4.ims.repository.ShoeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    private final BrandRepository brandRepository;
    private final InventoryRepository inventoryRepository;

    private final ShoeRepository shoeRepository;



    //To check if it works
    public ResponseEntity<String> placeOrder(AddShoeRequest addShoe) {
        for (ShoeOrder shoe : addShoe.getShoes()) {
            Shoe shoeCheck = shoeRepository.findByName(shoe.getShoeName());
            if (shoeCheck == null) {
                return ResponseEntity.badRequest().body("Shoe does not exist");
            }

            // Place order logic here

                List<Inventory> inventory = inventoryRepository
                        .findAll().stream().filter(inventory1 -> inventory1.getShoe().equals(shoeCheck))
                        .toList();

            inventory.forEach(inventory1 -> {
                if(inventory1.getColor().equals(shoe.getShoeColor()) && inventory1.getSize().equals(shoe.getShoeSize()))
                {
                    System.out.println("Shoe found in inventory");
                    inventory1.setQuantity(inventory1.getQuantity() - shoe.getQuantity());
                    inventoryRepository.save(inventory1);

                    Sales sale = Sales.builder()
                            .date(new Date())
                            .inventoryId(inventory1)
                            .totalPrice(inventory1.getPrice()*shoe.getQuantity())
                            .quantity(shoe.getQuantity())
                            .build();
                    customerRepository.save(sale);
                }
                    }
            );



            // Set other order details as needed
//            if (order.isPresent()){
//
//                existingOrder = order.get();
//                existingOrder.setShoeId(existingOrder.getShoeId());
//                existingOrder.setId(existingOrder.getId());
//                existingOrder.setQuantity(existingOrder.getQuantity() + shoe.getQuantity());
//
//                // Save the order in the customerRepository
//                customerRepository.save(existingOrder);
//            }


            // Update inventory logic here
            // Find inventory by shoe ID using inventoryRepository
//            Inventory inventoryStock = inventoryRepository.findInventoryByShoeId(shoeCheck.get().getId());

            // Update inventory stock quantity or mark the shoe as sold
//            inventoryStock.setQuantity(inventoryStock.getQuantity() - shoe.getQuantity());

            // Save the updated inventory in inventoryRepository
//            inventoryRepository.save(inventoryStock);



        }

        return ResponseEntity.ok("Order updated");
    }
}