package com.team4.ims.DTOs.Inventory.shoeDTO;

import com.team4.ims.DTOs.Inventory.brandDTO.BrandShoes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetShoeByBrandResponse {
    List<BrandShoes> shoes;
}
