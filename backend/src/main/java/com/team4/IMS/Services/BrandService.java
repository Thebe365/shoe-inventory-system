package com.team4.IMS.Services;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Repositorys.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;


    public ResponseEntity<Optional<Brand>> getById(Long BrandId) {
        return ResponseEntity.ok().body(brandRepository.findById(BrandId));
    }

    public ResponseEntity<?> deleteBrandById(Long BrandId){
        brandRepository.deleteById(BrandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Optional<Brand>> updateBrand(Brand brand){
        Brand presentBrand;
        Optional<Brand> optionalBrand = Optional.ofNullable(brandRepository.findBrandByName(brand.getName()));
        if (optionalBrand.isPresent()){
            presentBrand = optionalBrand.get();
            presentBrand.setName(brand.getName());
            presentBrand.setShoes(brand.getShoes());
            brandRepository.save(presentBrand);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(optionalBrand);
    }

    public ResponseEntity<?> getBrand(){
        System.out.println("before brands query");
        var brands = brandRepository.findAll();
        System.out.println("After brands query");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> addBrand(Brand brand){
//        var newBrand = brandRepository.findBrandByName(brand.getName());
//        newBrand.setName(brand.getName());
//        newBrand.setShoes(brand.getShoes());
//        brandRepository.save(newBrand);
//        return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.ok(brandRepository.findAll());
    }



}
