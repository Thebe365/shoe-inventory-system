<<<<<<< HEAD:backend/src/main/java/com/team4/ims/repository/BrandRepository.java
package com.team4.IMS.repository;
=======
package com.team4.ims.Repository;
>>>>>>> e5b8465 (fixing add shoe functionality):backend/src/main/java/com/team4/ims/Repository/BrandRepository.java

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {


    Optional<Brand> findBrandByName(String name);

    Brand findByName(String name);
}
