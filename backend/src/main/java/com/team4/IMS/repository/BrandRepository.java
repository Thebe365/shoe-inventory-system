package com.team4.IMS.repository;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
<<<<<<< HEAD:backend/src/main/java/com/team4/IMS/Repositorys/BrandRepository.java
=======
    Optional<Brand> findBrandByName(String name);



>>>>>>> acfa22a (Added DTO for swagger documentation):backend/src/main/java/com/team4/IMS/repository/BrandRepository.java

    Brand findByName(String name);
}
