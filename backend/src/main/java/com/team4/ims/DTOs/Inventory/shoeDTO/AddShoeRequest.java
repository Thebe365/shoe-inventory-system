package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddShoeRequest {
    private List<ShoeOrder> shoes;
}
