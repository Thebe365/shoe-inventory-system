package com.team4.IMS.Controllers;

import com.team4.IMS.DTOs.Auth.AuthenticationResponse;
import com.team4.IMS.DTOs.Inventory.addShoeRequest;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.Repositorys.ShoeRepository;
import com.team4.IMS.Services.ShoeService;
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

@RestController
@RequestMapping("/api/v1/shoes/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class ShoeController {

    private final ShoeService service;
    private final ShoeRepository shoeRepository;
    /* API Documentation*/
    @Operation(summary = "Fetching all shoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoes Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Users not found add retrieve"),
    })
    @GetMapping("getAll")
    public ResponseEntity<?> getShoes(){
        return service.getAllShoes();
    }

    @Operation(summary = "Fetching all shoes from a specific brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoes Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "404", description = "Users not retrieve"),
    })
    @GetMapping("brand/{brand}")
    public ResponseEntity<?> getShoesByBrand(@PathVariable String brand){
        String decodedName = URLDecoder.decode(brand, StandardCharsets.UTF_8);
        System.out.println("decodedName: " + decodedName);
        return service.getShoesByBrand(decodedName);
    }

    @Operation(summary = "Fetching all shoes from a specific brand request URL shoe name spaces must be replaced with %20")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoes Successfully Retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "400", description = "Shoe not found or does not exist"),
    })
    @GetMapping("name/{name}")
    public ResponseEntity<?> getShoesByName(@PathVariable String name){
        String decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8);
        System.out.println("decodedName: " + decodedName);
        return service.searchShoes(decodedName);
    }

    @Operation(summary = "Adding a shoe and updating inventory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoe Successfully added and inventory updated"),
            @ApiResponse(responseCode = "400", description = "one of the provided brands does not exist")
    })
    @PostMapping("addShoe")
    public ResponseEntity<?> addShoe(@RequestBody addShoeRequest addShoeRequest){
        System.out.println("addShoeRequest: " + addShoeRequest);
        return service.addShoes(addShoeRequest);
    }

    @Operation(summary = "Deleting a shoe and updating inventory ***This completely removes the shoe from the database***")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shoe Successfully deleted and inventory updated"),
            @ApiResponse(responseCode = "400", description = "Shoe not found or does not exist")
    })
    @DeleteMapping("deleteShoe/{id}")
    public ResponseEntity<?> deleteShoe(@PathVariable Long id){
        return service.deleteShoe(id);
    }


}
