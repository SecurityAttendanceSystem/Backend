package com.frdAttendance.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtException;

@Configuration
public class SecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;

    @Bean
    public JwtDecoder jwtDecoder() {
        NimbusJwtDecoder decoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
        
        // Add custom validation
        return token -> {
            try {
                System.out.println("Attempting to decode token...");
                var jwt = decoder.decode(token);
                System.out.println("Token decoded successfully");
                System.out.println("Token claims: " + jwt.getClaims());
                System.out.println("Token headers: " + jwt.getHeaders());
                System.out.println("Token issuer: " + jwt.getIssuer());
                System.out.println("Token audience: " + jwt.getAudience());
                System.out.println("Token subject: " + jwt.getSubject());
                
                // Validate issuer
                if (!jwt.getIssuer().toString().equals(issuerUri)) {
                    throw new JwtException("Invalid token issuer");
                }
                
                System.out.println("Token validation successful");
                return jwt;
            } catch (JwtException e) {
                System.out.println("JWT Validation failed: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/me").authenticated()
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .build();
    }

}


