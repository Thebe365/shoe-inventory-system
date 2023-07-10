package com.team4.ims.Services;


import com.team4.ims.DTOs.Inventory.brandDTO.AddBrandRequest;
import com.team4.ims.DTOs.Inventory.brandDTO.BrandById;
import com.team4.ims.Models.Brand;
import com.team4.ims.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final ShoeService shoeService;


    //Get Brand by id method
    public ResponseEntity<Brand> getById(Long id) {
        return ResponseEntity.ok().body(brandRepository.findById(id).get());
    }


    //Delete brand method
    public ResponseEntity deleteBrandById(Long id){
        brandRepository.deleteById(id);
        return ResponseEntity.ok().body("Brand successfully deleted");
    }


    //Update name of brand method
    public ResponseEntity<?> updateBrand(BrandById brandById){
        Brand presentBrand;
        Optional<Brand> optionalBrand = brandRepository.findById(brandById.getId());
        if (optionalBrand.isPresent()){
            presentBrand = optionalBrand.get();
            presentBrand.setName(brandById.getName());
            System.out.println("updated");
            brandRepository.save(presentBrand);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(optionalBrand);
    }


    //Get all brands method
    public ResponseEntity getAllBrands(){
        System.out.println("getAllBrands endpoint touched successfully");

        return ResponseEntity.ok(brandRepository.findAll());

//        List<BrandDetails> brandDetailsList = new ArrayList<>();
//        for (Brand brand: brandList) {
//            BrandDetails brandDetails = BrandDetails.builder()
//                    .brand(brand)
//                    .totalShoes(this.shoeService.countShoesByBrand(brand.getId()))
//                    .build();
//
//            brandDetailsList.add(brandDetails);
//        }
//
//        return ResponseEntity.ok(GetAllBrandsResponse.builder()
//                .brands(brandDetailsList)
//                .build());
    }


    //Create brand method
    public ResponseEntity<Brand> addBrand(AddBrandRequest addBrandRequest){
        Brand brand = Brand.builder().name(addBrandRequest.getName()).build();
        return ResponseEntity.ok(brandRepository.save(brand));

    }



}