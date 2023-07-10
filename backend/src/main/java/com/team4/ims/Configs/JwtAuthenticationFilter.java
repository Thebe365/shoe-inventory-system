package com.team4.ims.Configs;

import com.team4.ims.Services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    // doFilterInternal is called for every request
    // it is responsible for checking if the request has a valid JWT token
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
        ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        System.out.println(
                "JwtAuthenticationFilter.doFilterInternal: authHeader = " + authHeader
        );
        final String jwt;

        final String userEmail;
        final JwtService jwtService;

        if(request.getRequestURI().equals("/api/v1/auth/authenticate")) {
            System.out.println("request.getRequestURI().equals(\"/api/v1/auth/authenticate\")");
            filterChain.doFilter(request, response);
            return;
        }
        // Checks if the request has a valid JWT token
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("error returned from invalid token");
            filterChain.doFilter(request, response);
            return;
        }
        // Extracts the JWT token from the Authorization header
        jwt = authHeader.substring(7);
        userEmail = JwtService.extractUserEmail(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            // If the token is valid, it sets the user in the SecurityContext and allows the request to move forward
            if(JwtService.isTokenValid(jwt, userDetails)){
                System.out.println("token valid");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        System.out.println("request = " + request.getHeader("Authorization"));
        System.out.println("response = " + response);

        filterChain.doFilter(request, response);

    }
}
