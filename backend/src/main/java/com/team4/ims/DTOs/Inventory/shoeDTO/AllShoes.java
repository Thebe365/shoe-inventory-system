package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllShoes {

    private Long id;
    private String brand;
    private String name;
    private List<String> colors;
    private List<Integer> sizes;
    private int quantity;
//    private double price;


}
