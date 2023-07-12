package com.team4.ims.repository;


import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long>{
    Shoe findByName(String name);

    List<Shoe> findAllByName(String name);






}
