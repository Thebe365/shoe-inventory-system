package com.team4.IMS.repository;

import com.team4.IMS.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findInventoryByShoeId(Long id);

}
