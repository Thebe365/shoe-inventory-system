package com.team4.ims.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    private Long id;

    @NonNull
    @Column(name = "brand_name")
    private String name;

    @Column(name = "is_available")
    private Boolean isAvailable;

    //Reconsider this
//    @OneToMany(mappedBy = "brandId")
//    @JsonIgnore
//    private List<Shoe> shoes;
}
