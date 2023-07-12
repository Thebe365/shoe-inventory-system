//package com.team4.ims.Models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Data
//
//@EqualsAndHashCode(callSuper=false)
//@AllArgsConstructor
//@NoArgsConstructor(force = true)
//@Entity
//@Table(name = "Order")
//public class Order extends Shoe {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "order_id")
//    private Long id;
//
//
//    @Column(name = "quantity")
//    private int quantity;
//
//
//    @ManyToOne
//    @JoinColumn(name = "shoe_id", referencedColumnName = "shoe_id")
//    private Shoe shoeId;
//
//}
