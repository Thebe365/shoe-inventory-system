package com.team4.IMS.Services;

import com.team4.IMS.DTOs.Inventory.ShoeOrder;
import com.team4.IMS.DTOs.Inventory.addShoeRequest;
import com.team4.IMS.Models.Inventory;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.Repositorys.BrandRepository;
import com.team4.IMS.Repositorys.InventoryRepository;
import com.team4.IMS.Repositorys.ShoeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoeService {

    private final ShoeRepository shoeRepository;
    private final BrandRepository brandRepository;
    private final InventoryRepository inventoryRepository;

    public ResponseEntity<?> getAllShoes(){
        System.out.println("getAllShoes endpoint touched successfully");
        return ResponseEntity.ok(shoeRepository.findAll());
    }

    public ResponseEntity<?> getShoesByBrand(String brandName){
        return ResponseEntity.ok(shoeRepository.findAllByBrandId(brandRepository.findByName(brandName)));
    }

    public ResponseEntity<?> searchShoes(String search){
        return ResponseEntity.ok(shoeRepository.findAllByName(search));
    }

    public ResponseEntity<?> addShoes(addShoeRequest shoes){

        for (ShoeOrder shoe : shoes.getShoes()) {
            var brandCheck = brandRepository.findByName(shoe.getShoeBrand());
            var shoeCheck = shoeRepository.findAllByName(shoe.getShoeName());

            if(brandCheck == null){
                return ResponseEntity.badRequest().body("Brand does not exist");
            }
            if(shoeCheck != null){
                inventoryRepository.findInventoryByShoeId(shoeCheck.getId())
                        .setQuantity(inventoryRepository
                                .findInventoryByShoeId(shoeCheck.getId())
                                .getQuantity() + shoe.getQuantity());
                return ResponseEntity.ok("Quantity updated");
            }
            //TODO: Discuss creation of new shoes as part of ordering process
//            else{
//                Shoe newShoe = Shoe.builder()
//                        .brand(brandCheck)
//                        .name(shoe.getShoeName())
//                        .color(shoe.getShoeColor())
//                        .size(shoe.getShoeSize())
//                        .price(shoe.getShoePrice())
//                        .build();
//                Inventory newInventory = Inventory.builder()
//                        .shoe(newShoe)
//                        .quantity(shoe.getQuantity())
//                        .build();
//
//                shoeRepository.save(newShoe);
//                inventoryRepository.save(newInventory);
//            }
        }

        return ResponseEntity.badRequest().body("Shoe does not exist");

    }

    public ResponseEntity<?> deleteShoe(Long id){
        var inventoryUnit = inventoryRepository.findInventoryByShoeId(id);
        inventoryRepository.delete(inventoryUnit);
        shoeRepository.deleteById(id);
        return ResponseEntity.ok("Shoe deleted");
    }

}
