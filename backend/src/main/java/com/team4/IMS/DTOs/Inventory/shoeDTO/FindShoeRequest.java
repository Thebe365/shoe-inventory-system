package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FindShoeRequest {
    private String name;
    private String color;
}
