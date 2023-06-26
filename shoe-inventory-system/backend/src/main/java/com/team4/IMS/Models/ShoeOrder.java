package com.team4.IMS.Models;

import jakarta.persistence.*;
import lombok.*;


/*
! This class is not used in the current iteration of the project
* TODO: Fix table relationships
* */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "shoeOrders")
public class ShoeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @NonNull
    @ManyToMany
    private Shoe[] shoe;

    @NonNull
    private Double orderTotal;

}
