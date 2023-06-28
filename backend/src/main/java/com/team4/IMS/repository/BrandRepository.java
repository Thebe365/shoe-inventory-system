package com.team4.IMS.repository;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findBrandByName(String name);
    Brand findByName(String name);
}
