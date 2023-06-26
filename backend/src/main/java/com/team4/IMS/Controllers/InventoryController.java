package com.team4.IMS.Controllers;

import com.team4.IMS.DTOs.Inventory.addShoeRequest;
import com.team4.IMS.Repositorys.BrandRepository;
import com.team4.IMS.Repositorys.ShoeRepository;
import com.team4.IMS.Services.ShoeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class InventoryController {

    private final BrandRepository brandRepository;
    private final ShoeService shoeService;

    @GetMapping("brands")
    public ResponseEntity<?> getBrands(){
        return ResponseEntity.ok(brandRepository.findAll());
    }

    /**
     * TODO: Add a new brand
     * /
     * @return
     */
    @PostMapping("shoes")
    public ResponseEntity<?> addShoe(@RequestBody addShoeRequest addShoeRequest){
        System.out.println("addShoeRequest: " + addShoeRequest);
        return shoeService.addShoe(addShoeRequest);
    }





}
