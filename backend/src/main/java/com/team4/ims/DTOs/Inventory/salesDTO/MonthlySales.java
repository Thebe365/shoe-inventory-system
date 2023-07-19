package com.team4.ims.DTOs.Inventory.salesDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlySales {
    private int month;
    private int totalSales;
}
