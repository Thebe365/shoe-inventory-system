package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPriceRequest {
    private String shoeName;
    private String color;
    private int size;
}
