package com.team4.ims.Services;

import com.team4.ims.DTOs.Inventory.brandDTO.BrandShoes;
import com.team4.ims.DTOs.Inventory.shoeDTO.*;
import com.team4.ims.Models.Brand;
import com.team4.ims.Models.Inventory;
import com.team4.ims.Models.Shoe;
import com.team4.ims.Repository.BrandRepository;
import com.team4.ims.Repository.InventoryRepository;
import com.team4.ims.Repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoeService {


    private final ShoeRepository shoeRepository;
    private final BrandRepository brandRepository;
    private final InventoryRepository inventoryRepository;

    //gets all shoes
    public ResponseEntity<List<AllShoes>> getAllShoes(){
        List<AllShoes> responseShoes = new ArrayList<>();

        List<Shoe> allShoes = shoeRepository.findAll()
                .stream()
                .filter(shoe -> shoe.getIsAvailable().equals(true)).toList();


        for (Shoe shoe : allShoes) {

            int shoeCount = (int) inventoryRepository.findAllByShoe(shoe).stream().count();
            List<Integer> sizes = inventoryRepository
                    .findAll()
                    .stream()
                    .filter(inventory -> inventory
                            .getShoe()
                            .getName()
                            .equals(shoe.getName())
                    )
                    .map(Inventory::getSize)
                    .toList();
            List<String> colors = inventoryRepository
                    .findAll()
                    .stream()
                    .filter(inventory -> inventory
                            .getShoe()
                            .getName()
                            .equals(shoe.getName())
                    )
                    .map(Inventory::getColor)
                    .toList();

            AllShoes shoes = AllShoes.builder()
                    .brand(shoe.getBrand().getName())
                    .name(shoe.getName())
                    .id(shoe.getId())
                    .colors(colors)
                    .sizes(sizes)
                    .quantity(shoeCount)
//                    .price(shoe)
                    .build();

            responseShoes.add(shoes);

        }


        GetAllShoesResponse getShoesResponse = GetAllShoesResponse.builder()
                .shoes(responseShoes)
                .build();

        return ResponseEntity.ok(responseShoes);
    }

    //Fetches all shoes belonging to a specific brand
    public ResponseEntity<List<BrandShoes>> getShoesByBrand(String brandName){
        System.out.println("Brand name: " + brandName);
        Optional<Brand> brand = brandRepository.findByName(brandName);

        System.out.println("brand: " + brand);
        var shoes =shoeRepository.findAll()
                .stream()
                .filter(shoe -> shoe.getBrand().getName().equals(brandName))
                .filter(shoe -> shoe.getIsAvailable().equals(true))
                .toList();

        List<BrandShoes> brandShoesList = new ArrayList<>();

        for (Shoe shoeNames : shoes) {
            List<Integer> sizes = inventoryRepository
                    .findAll()
                    .stream()
                    .filter(inventory -> inventory
                            .getShoe()
                            .getName()
                            .equals(shoeNames.getName())
                    )
                    .distinct()
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
                    .distinct()
                    .map(Inventory::getColor)
                    .toList();
            int shoeQuantity = (int) inventoryRepository.findAllByShoe(shoeNames).stream().count();
            BrandShoes brandShoes = BrandShoes.builder()
                    .name(shoeNames.getName())
                    .brand(shoeNames.getBrand())
                    .sizes(sizes)
                    .colors(colors)
                    .quantity(shoeQuantity)
                    .build();

            brandShoesList.add(brandShoes);
        }

        GetShoeByBrandResponse response = GetShoeByBrandResponse.builder()
                .shoes(brandShoesList)
                .build();

        return ResponseEntity.ok(brandShoesList);
    }

    public int countShoes(String brandName){
       List<Shoe> shoes = shoeRepository.findAll().stream().filter(shoe -> shoe.getBrand().getName().equals(brandName)).toList();
         return shoes.size();
    }

    //Adds existing shoes to the database and updates inventory
    public ResponseEntity<String> addShoes(AddShoeRequest shoes){
        System.out.println("shoes"+ shoes.toString());
        for (ShoeOrder shoe : shoes.getShoes()) {
            Optional<Shoe> newShoe = shoeRepository.findByName(shoe.getShoeName());
            Optional<Inventory> inventoryUnit = inventoryRepository.findInventoryByColorAndSizeAndShoe(shoe.getShoeColor(), shoe.getShoeSize(), newShoe.get());

            if (newShoe.isEmpty()) {
                return ResponseEntity.badRequest().body("Shoe not found");
            } else if (inventoryUnit.isEmpty()) {
                Inventory newInventory = Inventory.builder().shoe(newShoe.get())
                        .size(Integer.parseInt((shoe.getShoeSize())))
                        .color(shoe.getShoeColor())
                        .quantity(shoe.getQuantity())
                        .price(100.00)
                        .build();
                inventoryRepository.save(newInventory);
                continue;
            }

            inventoryUnit.get().setQuantity(inventoryUnit.get().getQuantity() + shoe.getQuantity());
            inventoryRepository.save(inventoryUnit.get());

        }
        return ResponseEntity.ok().body("Quantity updated");

    }

    //Deletes a shoe from the database by ID
    public ResponseEntity<?> deleteShoe(DeleteShoeRequest shoe){
        //Sets the shoe to unavailable
        Optional<Shoe> shoeToDelete = shoeRepository.findByName(shoe.getName());
        if (shoeToDelete.isEmpty()){
            return ResponseEntity.badRequest().body("Shoe not found");
        }else{

            shoeToDelete.get().setIsAvailable(false);
            shoeRepository.save(shoeToDelete.get());
            return ResponseEntity.ok().body("Shoe deleted");
        }

    }

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
        Optional<Brand> brandCheck = brandRepository.findByName(shoe.getBrand());
        Optional<Shoe> shoeCheck = shoeRepository.findByName(shoe.getName());
        if(!brandCheck.isPresent()){
            return ResponseEntity.badRequest().body("The brand does not exist (Create a new one or double check spelling)");
        }
        if(!shoeCheck.isPresent()){
            System.out.println("creating shoe");
            Shoe newShoe = Shoe.builder()
                    .name(shoe.getName())
                    .brand(brandCheck.get())
                    .isAvailable(true)
                    .build();
            shoeRepository.save(newShoe);

            Inventory newInventory = Inventory.builder()
                    .shoe(newShoe)
                    .quantity(shoe.getQuantity())
                    .color(shoe.getColor())
                    .size(shoe.getSize())
                    .price(shoe.getPrice())
                    .build();
            inventoryRepository.save(newInventory);

        }else{
            if(shoeCheck.get().getIsAvailable().equals(false)){
                shoeCheck.get().setIsAvailable(true);
                shoeRepository.save(shoeCheck.get());
            }else{
                return ResponseEntity.badRequest().body("This shoe already exists");
            }
        }


        return ResponseEntity.ok("Shoe created");
    }

    //counts all shoes for a brand
    public int countShoesByBrand(Long brandId){
        return countShoes(brandRepository.findById(brandId).get().getName());
    }

}