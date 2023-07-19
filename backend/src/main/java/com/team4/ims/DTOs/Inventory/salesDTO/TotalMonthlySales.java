package com.team4.ims.DTOs.Inventory.salesDTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TotalMonthlySales {
    private List<MonthlySales> totalMonthlySales;
}
