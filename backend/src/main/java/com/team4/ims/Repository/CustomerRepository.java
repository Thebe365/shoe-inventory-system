package com.team4.ims.Repository;

import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Shoe, Long> {
    /**TODO: Implement CustomerRepository:
     *  1. Fetch available shoes for a customer ignore
     *  2. Fetch shoes of a specific color brand and size (Still under discussion)
     *  3. Purchase shoes and update the stock
     *  4. Filter by brand, color, name
     * */
}
