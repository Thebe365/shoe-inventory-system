package com.team4.ims.Models;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Shoes")
public class Shoe implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shoe_id")
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @NonNull
    @Column(name = "shoe_name")
    private String name;

    @Column(name = "is_available")
    private Boolean isAvailable;

//    @OneToMany(mappedBy = "shoe")
//    @JsonIgnore
//    private List<Inventory> inventory;


}
