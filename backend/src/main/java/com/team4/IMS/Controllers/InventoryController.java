package com.team4.IMS.Controllers;

import com.team4.IMS.Repositorys.BrandRepository;
import com.team4.IMS.Repositorys.ShoeRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class InventoryController {

    private final BrandRepository brandRepository;
    private final ShoeRepository shoeRepository;

    @GetMapping("brands")
    public ResponseEntity<?> getBrands(){
        return ResponseEntity.ok(brandRepository.findAll());
    }

    /**
     * TODO: Add a new brand
     * /
     * @return
     */
    @PostMapping("brands")
    public ResponseEntity<?> addBrand(){
        return ResponseEntity.ok(brandRepository.findAll());
    }


}
