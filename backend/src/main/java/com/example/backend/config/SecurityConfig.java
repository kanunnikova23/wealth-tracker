package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;

@Configuration // Marks this class as a configuration class
@EnableWebSecurity // Enables Spring Security's web security support
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Default constructor
        http
            // CSRF protection
            .csrf(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
            
            // Authorize requests  
            .authorizeHttpRequests((authz) -> authz
            .anyRequest().permitAll() // Allow all requests without authentication before JWT implementation
            
            );
        return http.build();
    }
    
}
