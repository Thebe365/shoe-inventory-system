package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.Data;

@Data
public class AddNewShoe {
    private String name;
    private String brand;
    private String color;
    private String size;
    private double price;
    private int quantity;
}
