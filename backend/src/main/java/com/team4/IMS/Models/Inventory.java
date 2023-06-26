package com.team4.IMS.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Inventory {

    /*
! This class is not used in the current iteration of the project
* TODO: Fix table relationships
* */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;

    @ManyToOne
    private Shoe shoe;

    private int quantity;

}
