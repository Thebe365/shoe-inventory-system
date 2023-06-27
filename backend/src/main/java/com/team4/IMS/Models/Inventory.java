package com.team4.IMS.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inventory {

    /*
! This class is not used in the current iteration of the project
* TODO: Fix table relationships
* */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;

    @JsonIgnore
    @ManyToOne
    private Shoe shoe;

    private int quantity;

}
