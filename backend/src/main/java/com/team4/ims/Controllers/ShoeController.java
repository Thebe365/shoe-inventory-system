package com.team4.ims.Controllers;

import com.team4.ims.DTOs.Inventory.brandDTO.BrandShoes;
import com.team4.ims.DTOs.Inventory.shoeDTO.*;
import com.team4.ims.Models.Shoe;
import com.team4.ims.Services.ShoeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/shoes/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class ShoeController {

    private final ShoeService service;

    /* API Documentation*/

    //Fetch all shoes
    @Operation(summary = "Fetching all shoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoes Successfully Retrieved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "404", description = "Users not found add retrieve"),
    })
    @GetMapping("getAll")
    public ResponseEntity<List<AllShoes>> getShoes() {
        return service.getAllShoes();
    }


    //Fetch all shoes by brand
    @Operation(summary = "Fetching all shoes from a specific brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoes Successfully Retrieved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "404", description = "Users not retrieve"),
    })
    @GetMapping("brand/{brand}")
    public ResponseEntity<List<BrandShoes>> getShoesByBrand(@PathVariable String brand) {
        String decodedName = URLDecoder.decode(brand, StandardCharsets.UTF_8);
        System.out.println("decodedName: " + decodedName);
        return service.getShoesByBrand(decodedName);
    }

    //Fetch a shoe by name
    @Operation(summary = "fetching a shoe by name request URL shoe name spaces must be replaced with %20")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoes Successfully Retrieved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "400", description = "Shoe not found or does not exist"),
    })
    @GetMapping("name/{name}")
    public ResponseEntity<List<Shoe>> getShoesByName(@PathVariable String name) {
        String decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8);
        System.out.println("decodedName: " + decodedName);
        return service.searchShoes(decodedName);
    }

    //Add already existing shoe to inventory
    @Operation(summary = "Add already existing shoes to inventory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoe Successfully added and inventory updated"),
            @ApiResponse(responseCode = "400", description = "one of the provided brands does not exist")
    })
    @PostMapping("addShoe")
    public ResponseEntity<String> addShoe(@RequestBody AddShoeRequest addShoeRequest) {
        System.out.println("addShoeRequest: " + addShoeRequest);
        return service.addShoes(addShoeRequest);
    }

    //Delete a shoe and update inventory
    @Operation(summary = "Deleting a shoe and updating inventory ***This makes shoes unavailable***")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoe Successfully delisted and inventory updated"),
            @ApiResponse(responseCode = "400", description = "Shoe not found or does not exist")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteShoe(@PathVariable Long id) {
        return service.deleteShoe(id);
    }

    //Create a new shoe and add it to inventory
    @Operation(summary = "Create a new Shoe", description = "Creates a new show belonging to a specific brand and adds it to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoe Successfully created and inventory updated"),
            @ApiResponse(responseCode = "400", description = "Shoe not found or does not exist")
    })
    @PostMapping("createShoe")
    public ResponseEntity<?> createShoe(@RequestBody AddNewShoe addShoeRequest) {
        System.out.println("addShoeRequest: " + addShoeRequest);
        return service.createShoe(addShoeRequest);
    }

    //Search for shoes by name and color
    @Operation(summary = "Search for shoes by name and color", description = "Search for shoes by name and color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoe Successfully created and inventory updated"),
            @ApiResponse(responseCode = "400", description = "Shoe not found or does not exist")
    })
    @PostMapping("searchShoes")
    public ResponseEntity<?> searchShoes(@RequestBody FindShoeRequest request) {
        return service.findShoe(request);
    }
}

