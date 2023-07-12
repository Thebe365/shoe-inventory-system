
package com.team4.ims.Repository;

import com.team4.ims.Models.Inventory;
import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findInventoryByShoe(Long id);

    List<Inventory> findAllByShoe(Shoe shoe);




}
