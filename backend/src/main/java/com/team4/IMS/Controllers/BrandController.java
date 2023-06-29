package com.team4.IMS.Controllers;

import com.team4.IMS.DTOs.Inventory.AddBrandRequest;
import com.team4.IMS.DTOs.Inventory.BrandById;
import com.team4.IMS.Models.Brand;
import com.team4.IMS.Services.BrandService;
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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/brand/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class BrandController {

    private final BrandService brandService;

    //Add a brand
    @Operation(summary = "Fetching all brands", description = "Fetching all brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brands Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Brands not found add retrieve"),
    })
    @PostMapping
    public ResponseEntity addBrands(@RequestBody AddBrandRequest addBrandRequest){
        return brandService.addBrand(addBrandRequest);
    }


    //Get all brands

    @Operation(summary = "Fetching all brands", description = "Fetching all brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brands Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Brands not found add retrieve"),
    })
    @GetMapping
    public ResponseEntity<List<Brand>> getBrands(){
        System.out.println("endpoint reached");
        return brandService.getBrand();
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
            return brandService.getById(id);
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
        return brandService.updateBrand(brandById);
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
            return brandService.deleteBrandById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
