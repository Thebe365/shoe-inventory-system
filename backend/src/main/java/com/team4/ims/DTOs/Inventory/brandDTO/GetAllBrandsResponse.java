package com.team4.ims.DTOs.Inventory.brandDTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllBrandsResponse {
    private List<BrandDetails> brands;
}
