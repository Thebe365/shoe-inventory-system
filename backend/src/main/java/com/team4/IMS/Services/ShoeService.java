package com.team4.IMS.Services;

<<<<<<< HEAD
import com.team4.IMS.DTOs.Inventory.ShoeOrder;
import com.team4.IMS.DTOs.Inventory.addShoeRequest;
import com.team4.IMS.Models.Brand;
import com.team4.IMS.Models.Inventory;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.repository.BrandRepository;
import com.team4.IMS.repository.InventoryRepository;
import com.team4.IMS.repository.ShoeRepository;
=======
import com.team4.ims.DTOs.Inventory.brandDTO.BrandShoes;
import com.team4.ims.DTOs.Inventory.shoeDTO.*;
import com.team4.ims.Models.Brand;
import com.team4.ims.Models.Inventory;
import com.team4.ims.Models.Shoe;
import com.team4.ims.Repository.BrandRepository;
import com.team4.ims.Repository.InventoryRepository;
import com.team4.ims.Repository.ShoeRepository;
>>>>>>> e5b8465 (fixing add shoe functionality)
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

<<<<<<< HEAD
    public ResponseEntity<?> getShoesByBrand(String brandName){
        return ResponseEntity.ok(shoeRepository.findAllByBrandId(brandRepository.findByName(brandName)));
=======
    //Fetches all shoes belonging to a specific brand
    public ResponseEntity<GetShoeByBrandResponse> getShoesByBrand(String brandName){
        System.out.println("Brand name: " + brandName);
        Optional<Brand> brand = brandRepository.findByName(brandName);
        // TODO: Find all shoe belonging to a specific brand in the inventory
        System.out.println("brand: " + brand);
        var shoes =shoeRepository.findAll();

        List<BrandShoes> brandShoesList = new ArrayList<>();

        for (Shoe shoeNames : shoes) {
            List<String> sizes = inventoryRepository
                    .findAll()
                    .stream()
                    .filter(inventory -> inventory
                            .getShoe()
                            .getName()
                            .equals(shoeNames.getName())
                    )
                    .map(Inventory::getSize)
                    .toList();
            List<String> colors = inventoryRepository
                    .findAll()
                    .stream()
                    .filter(inventory -> inventory
                            .getShoe()
                            .getName()
                            .equals(shoeNames.getName())
                    )
                    .map(Inventory::getColor)
                    .toList();
            BrandShoes brandShoes = BrandShoes.builder()
                    .name(shoeNames.getName())
                    .brand(shoeNames.getBrandId())
                    .sizes(sizes)
                    .colors(colors)
                    .build();

            brandShoesList.add(brandShoes);
        }

        GetShoeByBrandResponse response = GetShoeByBrandResponse.builder()
                .shoes(brandShoesList)
                .build();

        return ResponseEntity.ok(response);
>>>>>>> e5b8465 (fixing add shoe functionality)
    }

    public ResponseEntity<?> searchShoes(String search){
        return ResponseEntity.ok(shoeRepository.findAllByName(search));
    }



    public ResponseEntity<?> addShoes(addShoeRequest shoes){

        for (ShoeOrder shoe : shoes.getShoes()) {
            var brandCheck = brandRepository.findByName(shoe.getShoeBrand());
            var shoeCheck = shoeRepository.findAllByName(shoe.getShoeName());

<<<<<<< HEAD
            if(brandCheck == null){
                return ResponseEntity.badRequest().body("Brand does not exist");
            } else if (shoeCheck == null){
                return ResponseEntity.badRequest().body("Shoe does not exist");
            }
            if(shoeCheck != null){
                inventoryRepository.findInventoryByShoeId(shoeCheck.getId())
                        .setQuantity(inventoryRepository
                                .findInventoryByShoeId(shoeCheck.getId())
                                .getQuantity() + shoe.getQuantity());
                return ResponseEntity.ok("Quantity updated");
            }
=======
            Optional<Brand> brand = brandRepository.findByName(shoe.getShoeBrand());
            Optional<Shoe> newShoe = shoeRepository.findByName(shoe.getShoeName());

            List<Inventory> inventoryUnit = this.inventoryRepository
                    .findAll();

            for (Inventory inventory : inventoryUnit
            ){
                System.out.println("Inventory: " + inventory);
            }


            System.out.println("Brand: " + brand);
            System.out.println("Inventory: " + inventoryUnit);

            if(!brand.isPresent()){
                return ResponseEntity.badRequest().body("Brand not found");
            }
            if(!newShoe.isPresent()){
                return ResponseEntity.badRequest().body("Shoe not found");
            }

//            Inventory inventory = Inventory.builder()
//                    .shoe(inventoryUnit.get().getShoe())
//                    .color(shoe.getShoeColor())
//                    .size(shoe.getShoeSize())
//                    .quantity(shoe.getQuantity())
//                    .price(inventoryUnit.get().getPrice())
//                    .build();
//            inventoryRepository.save(inventory);
>>>>>>> e5b8465 (fixing add shoe functionality)

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

<<<<<<< HEAD
    
}
=======
    //Searches for shoes by name
    public ResponseEntity<List<Shoe>> searchShoes(String name){
        return ResponseEntity.ok(shoeRepository.findAllByName(name));
    }

    public ResponseEntity<List<Shoe>> findShoe(FindShoeRequest shoe){
        List<Long>  shoeIds= inventoryRepository
                .findAll()
                .stream()
                .filter(inventory -> inventory
                        .getColor()
                        .equals(shoe.getColor()) && inventory.getShoe().getName().equals(shoe.getName())
                ).
                map(inventory -> inventory.getShoe().getId())
                .toList();
        List<Shoe> shoes = new ArrayList<>();
        for (Long shoeId : shoeIds) {
            shoes.add(shoeRepository.findById(shoeId).get());
        }
        return ResponseEntity.ok(shoes);
    }


    //    Creates a new shoe and adds it to the database
    public ResponseEntity<?> createShoe(AddNewShoe shoe){
        Optional<Brand> brand = brandRepository.findByName(shoe.getBrand());
        if(brand.isPresent()){
            Shoe newShoe = Shoe.builder()
                    .name(shoe.getName())
                    .brandId(brand.get())
                    .isAvailable(true)
                    .build();

            Inventory newInventory = Inventory.builder()
                    .shoe(newShoe)
                    .quantity(shoe.getQuantity())
                    .color(shoe.getColor())
                    .size(shoe.getSize())
                    .price(shoe.getPrice())
                    .build();

            shoeRepository.save(newShoe);
            inventoryRepository.save(newInventory);

        }
        else{
            return ResponseEntity.badRequest().body("The brand does not exist (Create a new one or double check spelling)");
        }


        return ResponseEntity.ok("Shoe created");
    }

    //counts all shoes for a brand
    public int countShoesByBrand(Long brandId){
        return countShoes(brandRepository.findById(brandId).get().getName());
    }

}
>>>>>>> e5b8465 (fixing add shoe functionality)
