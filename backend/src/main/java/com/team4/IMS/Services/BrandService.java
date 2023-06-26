package com.team4.IMS.Services;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Repositorys.BrandRepository;
import lombok.RequiredArgsConstructor;
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

    public ResponseEntity<Optional<Brand>> deleteBrandById(Long BrandId){
        return ResponseEntity.ok().body(brandRepository.findById(BrandId));
    }

    public ResponseEntity<Optional<Brand>> updateBrand(Long BrandId){
        return ResponseEntity.ok().body(brandRepository.findById(BrandId));
    }



}
