package com.team4.IMS.DTOs.Inventory;

import com.team4.IMS.Models.Shoe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class addShoeRequest {
    private List<ShoeOrder> shoes;
}
