package com.team4.IMS.repository;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Models.Shoe;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Long>{
    Shoe findAllByName(String name);

    List<Shoe> findAllByBrandId(Brand brand);
    List<Shoe> findAllByBrand(Brand brand);
}
