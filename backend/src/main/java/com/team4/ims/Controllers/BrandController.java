package com.team4.ims.Controllers;


<<<<<<< HEAD:backend/src/main/java/com/team4/IMS/Controllers/BrandController.java
import com.team4.IMS.DTOs.Inventory.AddBrandRequest;
import com.team4.IMS.DTOs.Inventory.BrandById;
import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
=======
import com.team4.ims.DTOs.Inventory.brandDTO.AddBrandRequest;
import com.team4.ims.DTOs.Inventory.brandDTO.BrandById;
import com.team4.ims.Models.Brand;
>>>>>>> origin/master:backend/src/main/java/com/team4/ims/Controllers/BrandController.java
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
<<<<<<< HEAD:backend/src/main/java/com/team4/IMS/Controllers/BrandController.java
=======
@CrossOrigin(origins = "http://localhost:4200")
>>>>>>> origin/master:backend/src/main/java/com/team4/ims/Controllers/BrandController.java
@RequestMapping("/api/v1/brand/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class BrandController {

    private final com.team4.ims.Services.BrandService service;



    /**
     * TODO: Add a new brand
     * /
     * @return
     */


    //Add a brand
<<<<<<< HEAD:backend/src/main/java/com/team4/IMS/Controllers/BrandController.java
=======
    @Operation(summary = "Creating a new brand", description = "Creates a new brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brands Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Brand already exists"),
    })
>>>>>>> origin/master:backend/src/main/java/com/team4/ims/Controllers/BrandController.java
    @PostMapping
    public ResponseEntity addBrands(@RequestBody AddBrandRequest addBrandRequest){
        return service.addBrand(addBrandRequest);
    }


    //Get all brands

    @Operation(summary = "Fetching all brands", description = "Fetching all brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brands Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Brands not found add retrieve"),
    })
    @GetMapping("getAll")
    public ResponseEntity getBrands(){
        return service.getAllBrands();
    }


    //Get brand by id
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandsById(@PathVariable Long id){

        try{
            return service.getById(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


    //Update Brand by id
    @PutMapping
    public ResponseEntity updateBrandById(@RequestBody BrandById brandById){
        try{
            return service.updateBrand(brandById);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        return new ResponseEntity<>("Data not Found",HttpStatus.NOT_FOUND);
        }
    }


    //Delete a brand
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        try {
            return service.deleteBrandById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
