package com.team4.IMS.Repositorys;

import com.team4.IMS.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Long>{
    <List>Shoe findShoeByBrand(String brand);
}
