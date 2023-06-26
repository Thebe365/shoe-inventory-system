package com.team4.IMS.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "shoes")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "shoe")
    private List<Inventory> inventory;

//    @OneToMany(mappedBy = "shoe")
//    private List<ShoeOrder> shoeOrders;

//    @ManyToOne
//    private ShoeOrder shoeOrder;

    @NonNull
    private String color;
    @NonNull
    private String size;
    @NonNull
    private Double price;



}
