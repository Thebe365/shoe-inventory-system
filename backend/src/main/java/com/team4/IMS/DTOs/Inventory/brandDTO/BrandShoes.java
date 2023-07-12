package com.team4.ims.DTOs.Inventory.brandDTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BrandShoes {
    private String name;
    private double price;
    private String brand;
    private List<String> colors;
    private List<String> sizes;
    private int quantity;
}
