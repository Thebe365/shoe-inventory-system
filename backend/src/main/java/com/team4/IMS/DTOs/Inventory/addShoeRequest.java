package com.team4.IMS.DTOs.Inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class addShoeRequest {
    private String name;
    private String brandName;
    private String color;
    private String size;
    private Double price;
    private Integer quantity;
}
