package com.team4.IMS.Controllers;

import com.team4.IMS.DTOs.AuthenticationRequest;
import com.team4.IMS.Services.AuthenticationService;
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
    @PostMapping("authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest loginDto) {
        try{
            return authenticationService.authenticate(loginDto);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Invalid username/password supplied", HttpStatus.UNAUTHORIZED);
        }
    }
}
