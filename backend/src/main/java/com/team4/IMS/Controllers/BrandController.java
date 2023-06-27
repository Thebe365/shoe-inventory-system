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
public class BrandController {

    private final BrandService brandService;




    /**
     * TODO: Add a new brand
     * /
     * @return
     */
    @PostMapping("addBrand")
    public ResponseEntity<?> addBrands(@RequestBody Brand brand){
        return brandService.addBrand(brand);
    }

    @GetMapping("brand")
    public ResponseEntity<?> getBrands(){
        System.out.println("endpoint reached");
        return brandService.getBrand();
    }



    @GetMapping("brand/{id}")
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

    @PutMapping("update")
    public ResponseEntity<?> updateBrandById(@RequestBody Brand brand){
        try{
        return brandService.updateBrand(brand);
        }catch(Exception ex) {
        return new ResponseEntity<>("Data not Found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        try {
            return brandService.deleteBrandById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
