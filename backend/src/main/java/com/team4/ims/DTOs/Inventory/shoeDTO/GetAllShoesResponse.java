package com.team4.ims.DTOs.Inventory.shoeDTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllShoesResponse {
    List<AllShoes> shoes;
}
