
package com.team4.ims.repository;

import com.team4.ims.Models.Inventory;
import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findInventoryByShoe(Long id);
//    Inventory findInventoryByShoeIdAndColorAndSize(Long id, String color, String size);

    List<Inventory> findAllByShoe(Shoe shoe);




}
