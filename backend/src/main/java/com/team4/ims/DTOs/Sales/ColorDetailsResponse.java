package com.team4.ims.DTOs.Sales;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColorDetailsResponse {
    private String color;
    private int totalSales;
}
