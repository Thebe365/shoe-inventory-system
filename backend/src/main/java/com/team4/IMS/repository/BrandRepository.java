<<<<<<< HEAD
package com.team4.ims.repository;

import com.team4.ims.Models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findBrandByName(String brandName);
    Optional<Brand> findByName(String brandName);
=======
package com.team4.IMS.repository;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findBrandByName(String name);
    Brand findByName(String name);
>>>>>>> cfaba24 (Customer services)
}
