package com.team4.ims.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "Brands", schema = "dbo")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    private Long id;

    @NonNull
    @Column(name = "brand_name")
    private String name;
//
//    @Column(name = "is_available")
//    private Boolean isAvailable;

    //Reconsider this
//    @OneToMany(mappedBy = "brand")
//    @JsonIgnore
//    private List<Shoe> shoes;
}
