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


    public ResponseEntity<Optional<Brand>> getById(Long id) {
        return ResponseEntity.ok().body(brandRepository.findById(id));
    }

    public ResponseEntity<?> deleteBrandById(Long id){
        brandRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    public ResponseEntity<?> updateBrand(Brand brand){
//        Brand presentBrand;
//        Optional<Brand> optionalBrand = brandRepository.findById(brand.getId());
//        if (optionalBrand.isPresent()){
//            presentBrand = optionalBrand.get();
//            presentBrand.setName(brand.getName());
//            System.out.println("updated");
//            brandRepository.save(presentBrand);
//        }else{
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return ResponseEntity.ok(optionalBrand);
//    }

    public ResponseEntity<?> getBrand(){
        return ResponseEntity.ok(brandRepository.findAll());
    }

    public ResponseEntity<?> addBrand(){
        return ResponseEntity.ok(brandRepository.findAll());
    }




}
