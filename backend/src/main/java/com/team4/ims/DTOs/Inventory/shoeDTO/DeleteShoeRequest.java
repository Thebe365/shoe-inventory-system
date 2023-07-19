package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteShoeRequest {
    private String name;
    private int size;
    private String color;
}
