package com.team4.IMS.Services;

import com.team4.IMS.DTOs.Inventory.addShoeRequest;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.Repositorys.BrandRepository;
import com.team4.IMS.Repositorys.InventoryRepository;
import com.team4.IMS.Repositorys.ShoeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoeService {

    ShoeRepository shoeRepository;
    BrandRepository brandRepository;
    InventoryRepository inventoryRepository;

    /**
     *
     * @param addShoeRequest
     * @return
     * 400 - Bad Request if the brand does not exist
     * 200 - OK if the shoe was added
     * 200 - OK if the shoe quantity was updated
     */

    public ResponseEntity<?> addShoe(addShoeRequest addShoeRequest){
        System.out.println("addShoeRequest: " + addShoeRequest);
        var checkShoe = this.shoeRepository.findShoeByName(addShoeRequest.getName());
        if(checkShoe != null){
           var stockUnit = inventoryRepository.findInventoryByShoeId(checkShoe.getId());
           stockUnit.setQuantity(stockUnit.getQuantity() + addShoeRequest.getQuantity());
           return ResponseEntity.ok("Shoe quantity updated");
        }else{
            var checkBrand = this.brandRepository.findBrandByName(addShoeRequest.getBrandName());
            if(checkBrand == null){
                return ResponseEntity.badRequest().body("Brand does not exist");
            }else{
                Shoe newShoe = Shoe.builder()
                        .brand(checkBrand)
                        .name(addShoeRequest.getName())
                        .color(addShoeRequest.getColor())
                        .size(addShoeRequest.getSize())
                        .price(addShoeRequest.getPrice())
                        .build();

                this.shoeRepository.save(newShoe);
                return ResponseEntity.ok("Shoe added");

            }
        }
    }

}
