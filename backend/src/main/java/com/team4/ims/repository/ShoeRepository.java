package com.team4.ims.repository;

<<<<<<< HEAD
import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
=======
import com.team4.ims.Models.Brand;
import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> cfaba24 (Customer services)
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long>{
    Shoe findByName(String name);
    List<Shoe> findAllByName(String name);
<<<<<<< HEAD

=======
    List<Shoe> findAllByBrandId(Brand brand);

    @Query("SELECT u FROM Shoe u WHERE u.color = :color AND u.size = :size AND u.name = :name")
    Shoe findShoeByColorSizeAndName(@Param("color") String color,
                                    @Param("size") String size,
                                    @Param("name") String name);

    @Query(value = "SELECT DISTINCT u.shoe_name FROM Shoes u WHERE u.brand_id = :brand", nativeQuery = true)
    List<String> findAllUniqueShoes( @Param("brand") Long brand);

    @Query("SELECT DISTINCT u.color FROM Shoe u WHERE u.name = :name")
    List<String> findAllUniqueColors( @Param("name") String name);

    @Query("SELECT DISTINCT u.size FROM Shoe u WHERE u.name = :name")
    List<String> findAllUniqueSizes( @Param("name") String name);

    @Query(value = "SELECT COUNT(u) FROM Shoes u WHERE u.brandId = :brand", nativeQuery = true)
    int CountShoesByBrand(@Param("brand") Long brand);
>>>>>>> cfaba24 (Customer services)



}
