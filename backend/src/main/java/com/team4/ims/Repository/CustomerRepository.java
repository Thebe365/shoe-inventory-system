package com.team4.ims.Repository;

import com.team4.ims.Models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Sales, Long> {
    List<Sales> findSalesByDate(Date date);


    /**
     *
     * TODO: Implement CustomerRepository:
     *  1. Fetch available shoes for a customer ignore
     *  2. Fetch shoes of a specific color brand and size (Still under discussion)
     *  3. Purchase shoes and update the stock
     */

}
