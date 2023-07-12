package com.team4.ims.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sales_id")
    private Long id;

    @NonNull
    @Column(name = "quantity")
    private int quantity;

    @NonNull
    @Column(name = "total_price")
    private Double totalPrice;

    @NonNull
    @Column(name = "date")
    private Date date;


    @OneToOne(targetEntity = Inventory.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    private Inventory inventoryId;


}
