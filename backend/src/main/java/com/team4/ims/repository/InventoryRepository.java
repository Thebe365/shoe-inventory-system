<<<<<<< HEAD
package com.team4.ims.repository;

import com.team4.ims.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findInventoryByShoeId(Long id);
    Inventory findInventoryByShoeIdAndColorAndSize(Long id, String color, String size);


=======
package com.team4.IMS.repository;

import com.team4.IMS.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findInventoryByShoeId(Long id);
>>>>>>> cfaba24 (Customer services)

}
