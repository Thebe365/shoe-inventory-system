package com.team4.IMS.Controllers;

import com.team4.IMS.DTOs.AuthenticationRequest;
import com.team4.IMS.DTOs.AuthenticationResponse;
import com.team4.IMS.Models.User;
import com.team4.IMS.Services.AuthenticationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
@OpenAPIDefinition
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    private final AuthenticationService authenticationService;

    /**
     * This method is used to register a new user
     * @param loginDto

     * @return ResponseEntity<?>
     * may return JWT token if successful with status code 200
     * or return a message with status code 400
     */

    @Operation(summary = "Login a user using email and password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Authentication Successful",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthenticationResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "User Authentication Failed"),
             })
    @PostMapping("authenticate")
    public ResponseEntity<?> authenticate(@RequestBody() AuthenticationRequest loginDto) {
        try{
            return authenticationService.authenticate(loginDto);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Invalid username/password supplied", HttpStatus.UNAUTHORIZED);
        }
    }
}
