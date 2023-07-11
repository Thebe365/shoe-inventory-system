package com.team4.ims.DTOs.Inventory.brandDTO;

import com.team4.ims.Models.Brand;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandDetails {
    private Brand brand;
    private int totalShoes;
}
