package com.team4.IMS.Repositorys;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByName(String name);



}
