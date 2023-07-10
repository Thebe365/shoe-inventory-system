package com.team4.ims.repository;

import com.team4.ims.Models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findBrandByName(String brandName);
    Optional<Brand> findByName(String brandName);
}
