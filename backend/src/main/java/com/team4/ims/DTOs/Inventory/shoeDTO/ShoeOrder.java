
package com.team4.ims.DTOs.Inventory.shoeDTO;


import lombok.Data;

@Data
public class ShoeOrder {

    private String shoeName;
    private String shoeColor;
    private String shoeSize;
    private String shoeBrand;
    int quantity;
}
