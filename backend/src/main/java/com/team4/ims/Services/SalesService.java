package com.team4.ims.Services;

import com.team4.ims.DTOs.Inventory.salesDTO.MonthlySales;
import com.team4.ims.DTOs.Inventory.salesDTO.TotalMonthlySales;
import com.team4.ims.DTOs.Sales.BrandSalesDetails;
import com.team4.ims.DTOs.Sales.ColorDetailsResponse;
import com.team4.ims.Models.Brand;
import com.team4.ims.Models.Sales;
import com.team4.ims.Repository.BrandRepository;
import com.team4.ims.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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
        List<Sales> sales = customerRepository.findAfterDate(date);
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
        Date date = new Date(startTime);
        System.out.println("Start date: "+ date);
        List<Sales> sales = customerRepository.findAfterDate(date);
        sales.forEach(sale -> System.out.println("sale: "+sale));
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

    //get total sales per month
    public ResponseEntity getTotalSalesPerMonth(Long startTime){
        Date date = new Date(startTime);
        List<Sales> sales = customerRepository.findAfterDate(date);
        List<MonthlySales> totalSales = new ArrayList<>();
        System.out.println("date: "+date);
        Calendar cal = Calendar.getInstance();

        for(int i = 0; i < 12; i++){
            int total = 0;
            for(Sales sale : sales){
                cal.setTime(sale.getDate());
                int month = cal.get(Calendar.MONTH);

                if(month == i){
                    total++;
                }
            }
            MonthlySales monthlySales = MonthlySales.builder()
                    .month(i)
                    .totalSales(total)
                    .build();
            totalSales.add(monthlySales);
        }
        TotalMonthlySales totalMonthlySales = TotalMonthlySales.builder()
                .totalMonthlySales(totalSales)
                .build();
    return ResponseEntity.ok(totalMonthlySales);
    }


}
