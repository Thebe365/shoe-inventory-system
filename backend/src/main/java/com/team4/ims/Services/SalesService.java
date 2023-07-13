package com.team4.ims.Services;

import com.team4.ims.DTOs.Sales.BrandSalesDetails;
import com.team4.ims.DTOs.Sales.ColorDetailsResponse;
import com.team4.ims.Models.Brand;
import com.team4.ims.Models.Sales;
import com.team4.ims.Repository.BrandRepository;
import com.team4.ims.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final CustomerRepository customerRepository;
    private final BrandRepository brandRepository;

    //gets brands performance
    public ResponseEntity<List<BrandSalesDetails>> brandPerformance(Long startTime){
        //convert epooc to date

        if(startTime == null){
            startTime = 0L;
        }
        Date date = new Date(startTime);
        List<Brand> brands = brandRepository.findAll();
        List<Sales> sales = customerRepository.findSalesByDate(date);

//        List<Sales> sales = customerRepository.findAll();

        List<BrandSalesDetails> salesResponse = new ArrayList<>();

        brands.forEach(brand ->{
            int totalSales = sales.stream().filter(sale -> sale.getInventoryId()
                    .getShoe()
                    .getBrand()
                    .getName()
                    .equals(brand.getName()))
                    .toList()
                    .size();

            BrandSalesDetails brandSalesDetails = BrandSalesDetails.builder()
                    .Name(brand.getName())
                    .totalSales(totalSales)
                    .build();

            salesResponse.add(brandSalesDetails);
        });

        return ResponseEntity.ok(salesResponse);


    }

    //gets color performance
    public ResponseEntity<List<ColorDetailsResponse>> colorPerformance(Long startTime){
        if(startTime == null){
            startTime = 0L;
        }

        Date date = new Date(startTime);
        List<Sales> sales = customerRepository.findSalesByDate(date);
        List<String> colors = sales.stream().map(sale -> sale.getInventoryId().getColor()).toList();
        List<ColorDetailsResponse> colorDetailsResponses = new ArrayList<>();

        colors.forEach(color -> {
            int totalSales = sales.stream().filter(sale -> sale.getInventoryId().getColor().equals(color)).toList().size();

            ColorDetailsResponse colorDetailsResponse = ColorDetailsResponse.builder()
                    .color(color)
                    .totalSales(totalSales)
                    .build();

            colorDetailsResponses.add(colorDetailsResponse);
        });

        return ResponseEntity.ok(colorDetailsResponses);
    }


}
