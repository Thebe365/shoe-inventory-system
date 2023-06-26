package com.team4.IMS.Configs;

import com.team4.IMS.Services.JwtService;
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

        if(request.getRequestURI().equals("/api/v1/auth/authenticate")){
            System.out.println("request.getRequestURI().equals(\"/api/v1/auth/authenticate\")");
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("error returned from invalid token");
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        System.out.println("extracted jwt = " + jwt);
        userEmail = JwtService.extractUserEmail(jwt);
        System.out.println("extracted userEmail = " + userEmail);
        System.out.println("SecurityContextHolder.getContext().getAuthentication() = " + SecurityContextHolder.getContext().getAuthentication());
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("userEmail not null and SecurityContextHolder.getContext().getAuthentication() == null");
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            System.out.println("userDetails = " + userDetails);
            if(JwtService.isTokenValid(jwt, userDetails)){
                System.out.println("token valid");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                System.out.println("authToken = " + authToken);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("SecurityContextHolder.getContext().getAuthentication() = " + SecurityContextHolder.getContext().getAuthentication());
            }
        }
        System.out.println("request = " + request.getHeader("Authorization"));
        System.out.println("response = " + response);

        filterChain.doFilter(request, response);

    }
}
