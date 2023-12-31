package com.team4.ims.Services;

import com.team4.ims.DTOs.Auth.AuthenticationRequest;
import com.team4.ims.DTOs.Auth.AuthenticationResponse;
import com.team4.ims.DTOs.Auth.RegistrationRequest;
import com.team4.ims.Models.Roles;
import com.team4.ims.Models.User;
import com.team4.ims.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    //Authenticate user (Login)
    public ResponseEntity<?> authenticate(AuthenticationRequest request) {
       if(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())).isAuthenticated()){
            var user = userRepository.findUserByEmail(request.getEmail());
            var jwtToken = jwtService.generateToken(user.getEmail(),user.getId(),user.getRole());
            return ResponseEntity.ok().body(new AuthenticationResponse(jwtToken));
        }else
            return ResponseEntity.badRequest().body("User does not exist");

    }

    //Register user
    public ResponseEntity<?> register(RegistrationRequest request) {
        if(userRepository.findUserByEmail(request.getEmail()) != null){
            User newUser = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Roles.CUSTOMER)
                    .build();

            userRepository.save(newUser);
            AuthenticationResponse response = AuthenticationResponse.builder()
                    .token(jwtService.generateToken(newUser.getEmail(),newUser.getId(),newUser.getRole()))
                    .build();

            return ResponseEntity.ok().body(response);
        }else
            return ResponseEntity.badRequest().body("User already exists");
    }
}


