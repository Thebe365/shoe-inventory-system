package com.team4.IMS.Services;

import com.team4.IMS.DTOs.AuthenticationRequest;
import com.team4.IMS.DTOs.AuthenticationResponse;
import com.team4.IMS.Repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public ResponseEntity<?> authenticate(AuthenticationRequest request) {
       if(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())).isAuthenticated()){
            var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User already exists"));
            var jwtToken = jwtService.generateToken(user.getEmail(),user.getId());
            return ResponseEntity.ok().body(new AuthenticationResponse(jwtToken));
        }else
            return ResponseEntity.badRequest().body("User does not exist");

    }
}


