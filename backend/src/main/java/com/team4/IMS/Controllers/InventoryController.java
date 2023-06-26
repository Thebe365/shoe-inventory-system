package com.team4.IMS.Controllers;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Repositorys.BrandRepository;
import com.team4.IMS.Repositorys.ShoeRepository;
import com.team4.IMS.Services.BrandService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inventory/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class InventoryController {

    private final BrandRepository brandRepository;
    private final BrandService brandService;
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



    @GetMapping("brands/{id}")
    public ResponseEntity<?> getBrandsByIds(@PathVariable Long BrandId){
        Map<String, Object> map = new LinkedHashMap<>();
        try{
            return brandService.getById(BrandId);
        }catch(Exception ex){
            map.clear();
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBrandById(@RequestBody Brand brand){
        Map<String, Object> map = new LinkedHashMap<>();
        Brand brandExist = null;
        try{
            Optional<Brand> brandOptional = brandRepository.findById(brand.getBrandId());
            if (brandOptional.isPresent()){
                brandExist = brandOptional.get();
                brandExist.setBrandName(brand.getBrandName());
                brandExist.setShoes(brand.getShoes());
                brandRepository.save(brandExist);
            }

        }catch(Exception ex) {
            map.clear();
            map.put("message", "Data not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id){
        Map<String, Object> map = new LinkedHashMap<>();
        try{
            return brandService.deleteBrandById(id);
        }catch(Exception ex){
            map.clear();
            map.put("message", "Data not found");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
    }




}
