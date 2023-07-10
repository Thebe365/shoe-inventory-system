package com.team4.IMS.repository;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Models.Shoe;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Long>{
    Shoe findByName(String name);
    List<Shoe> findAllByName(String name);
    List<Shoe> findAllByBrandId(Brand brand);

    @Query(value = "SELECT * FROM Shoe u WHERE u.color = :color AND u.size = :size AND u.name = :name", nativeQuery = true)
    Shoe findShoeByColorSizeAndName( @Param("color") String color,
                                     @Param("size") String size,
                                     @Param("name") String name);

}
