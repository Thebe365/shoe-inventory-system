package com.team4.ims.DTOs.Sales;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandSalesDetails {
    private String Name;
    private int totalSales;
}
