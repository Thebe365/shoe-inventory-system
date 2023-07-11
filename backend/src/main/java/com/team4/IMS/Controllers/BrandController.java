package com.team4.ims.Controllers;


import com.team4.ims.DTOs.Inventory.brandDTO.AddBrandRequest;
import com.team4.ims.DTOs.Inventory.brandDTO.BrandById;
import com.team4.ims.Models.Brand;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/brand/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class BrandController {

    private final com.team4.ims.Services.BrandService service;


    //Add a brand
    @Operation(summary = "Creating a new brand", description = "Creates a new brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brands Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Brand already exists"),
    })
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
        @Operation(summary = "Fetching fetch a brand by its ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "brand Successfully Retrieved",
                        content = { @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Brand.class)) }),
                @ApiResponse(responseCode = "404", description = "Brand not found brand my not exist or ID is wrong"),
        })
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
    @Operation(summary = "Updating a brand by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brand Successfully Updated"),
            @ApiResponse(responseCode = "404", description = "Brand not found"),
    })
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
    @Operation(summary = "Delete a brand by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brand Successfully Deleted"),
            @ApiResponse(responseCode = "404", description = "Brand not found brand my not exist or ID is wrong"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        try {
            return service.deleteBrandById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
