package com.team4.ims.repository;

import com.team4.ims.Models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> cfaba24 (Customer services)
@Repository
public interface CustomerRepository extends JpaRepository<Shoe, Long> {
    /**TODO: Implement CustomerRepository:
     *  1. Fetch available shoes for a customer ignore
     *  2. Fetch shoes of a specific color brand and size (Still under discussion)
     *  3. Purchase shoes and update the stock
<<<<<<< HEAD
     *  4. Filter by brand, color, name
     * */
=======
     * */

    List<Shoe>findShoesByName(String name);
>>>>>>> cfaba24 (Customer services)
}
