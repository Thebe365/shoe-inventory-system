package com.team4.ims.Services;


import com.team4.ims.DTOs.Inventory.brandDTO.BrandShoes;
import com.team4.ims.DTOs.Inventory.shoeDTO.GetShoeByBrandResponse;
import com.team4.ims.Models.Brand;
import com.team4.ims.Models.Shoe;
import com.team4.ims.repository.BrandRepository;
import com.team4.ims.repository.CustomerRepository;
import com.team4.ims.repository.ShoeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    //Todo: Implement CustomerService:
    /**
     * 1. Shoes of a specific color brand and size (Still under discussion)
     * 2. Purchase shoes and update the stock
     * */
    @Autowired
    private final CustomerRepository customerRepository;
    private final BrandRepository brandRepository;
    private final ShoeRepository shoeRepository;

    public ResponseEntity<List<Shoe>> getCustomerShoes(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    //To check if it works
    public ResponseEntity<GetShoeByBrandResponse> getShoesByBrand(String brandName){
        Brand brand = brandRepository.findBrandByName(brandName).orElseThrow();

        List<String> shoes = shoeRepository.findAllUniqueShoes(brand.getId());
        List<BrandShoes> brandShoesList = new ArrayList<>();

        for (String shoeNames : shoes) {
            var shoe= customerRepository.findShoesByName(shoeNames);
            BrandShoes brandShoes = BrandShoes.builder()
                    .name(shoe.get(1).getName())
                    .brand(shoe.get(1).getBrandId())
                    .sizes(shoeRepository.findAllUniqueSizes(shoe.get(1).getName()))
                    .colors(shoeRepository.findAllUniqueColors(shoe.get(1).getName()))
                    .build();

            brandShoesList.add(brandShoes);
        }

        GetShoeByBrandResponse response = GetShoeByBrandResponse.builder()
                .shoes(brandShoesList)
                .build();

        return ResponseEntity.ok(response);
    }
}
