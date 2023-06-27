package com.team4.IMS.Controllers;

import com.team4.IMS.DTOs.Inventory.addShoeRequest;
import com.team4.IMS.Repositorys.ShoeRepository;
import com.team4.IMS.Services.ShoeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoes/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class ShoeController {

    private final ShoeService service;
    private final ShoeRepository shoeRepository;

    @GetMapping("getAll")
    public ResponseEntity<?> getShoes(){
        return service.getAllShoes();
    }

    @GetMapping("shoe/brand/{brand}")
    public ResponseEntity<?> getShoesByBrand(@PathVariable String brand){
        return service.getShoesByBrand(brand);
    }

    @GetMapping("shoe/name/{name}")
    public ResponseEntity<?> getShoesByName(@PathVariable String name){
        return service.searchShoes(name);
    }

    @PostMapping("addShoe")
    public ResponseEntity<?> addShoe(@RequestBody addShoeRequest addShoeRequest){
        System.out.println("addShoeRequest: " + addShoeRequest);
        return service.addShoes(addShoeRequest);
    }


}
