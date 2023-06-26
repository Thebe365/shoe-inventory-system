package com.team4.IMS.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long BrandId;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Shoe> shoes;
}
