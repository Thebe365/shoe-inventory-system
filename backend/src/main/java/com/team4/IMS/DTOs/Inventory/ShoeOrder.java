package com.team4.IMS.DTOs.Inventory;

import com.team4.IMS.Models.Shoe;
import lombok.Data;

@Data
public class ShoeOrder {

    private String shoeName;
    private String shoeColor;
    private String shoeSize;
    private String shoeBrand;
    int quantity;
}
