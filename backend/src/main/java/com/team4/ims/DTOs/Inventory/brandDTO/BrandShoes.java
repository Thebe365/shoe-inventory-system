package com.team4.ims.DTOs.Inventory.brandDTO;

import com.team4.ims.Models.Brand;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BrandShoes {
    private String name;
    private double price;
    private Brand brand;
    private int quantity;
    private List<String> colors;
    private List<Integer> sizes;
}
