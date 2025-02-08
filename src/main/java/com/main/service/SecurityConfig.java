package com.main.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())  
            .authorizeHttpRequests(auth -> 
                auth
                    .requestMatchers("/", "/register", "/registration-success", "/withdraw.html").permitAll()  
                    .anyRequest().authenticated()  
            )
            .formLogin(login -> 
                login.permitAll()  
            )
            .logout(logout -> 
                logout.permitAll()  
            )
            .build();
    }
}
