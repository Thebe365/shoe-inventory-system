package com.team4.ims.Repository;


import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long>{
    Optional<Shoe> findByName(String name);

    List<Shoe> findAllByName(String name);






}
