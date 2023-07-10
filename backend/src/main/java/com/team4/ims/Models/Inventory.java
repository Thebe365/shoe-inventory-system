package com.team4.ims.Models;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "shoe", referencedColumnName = "shoe_id")
    private Shoe shoe;

    @Column(name = "quantity")
    private int quantity;

    @NonNull
    @Column(name = "color")
    private String color;

    @NonNull
    @Column(name = "size")
    private String size;

    @NonNull
    @Column(name = "price")
    private Double price;

}
