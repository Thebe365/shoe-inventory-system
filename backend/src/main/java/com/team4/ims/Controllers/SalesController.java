package com.team4.ims.Controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class SalesController {

    //brand performance endpoint
    /**
     * 1. Returns the total sales for all brands specific brand
     * 2. takes a date range as a filter
     */
    @PostMapping("brands")
    public ResponseEntity<?> getBrandPerformance() {
        return null;
    }



    //Popular color endpoint
    /**
     * 1. Returns the total sales for each color
     * 2. takes a date range as a filter
     */
    @GetMapping("popularColor")
    public ResponseEntity<?> getPopularColor() {
        return null;
    }

    //Total sales permonth endpoint
    /**
     * 1. Returns the total sales for each month
     * 2. takes a date range as a filter
     */
    @GetMapping("totalSalesPerMonth")
    public ResponseEntity<?> getTotalSalesPerMonth() {
        return null;
    }




        

}
//Sales Endpoint
/**
 * 1. Return Sales for a specific month [array of sales information for that month(specified by user)]
 * 		1.2. Filter by month range
 * 		1.3. Filter by Shoe
 * 3. returns most popular shoes [based on total highest sales per shoe]
 * 4. return the total sales for a specific months
 * 		4.1. Filter by month range
 */
