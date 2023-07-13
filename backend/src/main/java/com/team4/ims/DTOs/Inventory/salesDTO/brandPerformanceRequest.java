package com.team4.ims.DTOs.Inventory.salesDTO;

import lombok.Data;

import java.util.List;

@Data
public class brandPerformanceRequest {
    private List<BrandSales> brandSales;
}
