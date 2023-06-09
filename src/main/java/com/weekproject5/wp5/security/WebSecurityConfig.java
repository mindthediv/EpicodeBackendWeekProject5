package com.weekproject5.wp5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired private AuthenticationEntryPoint authEntryPoint;

    @Autowired public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .inMemoryAuthentication()
        .withUser("user1")
        .password(passwordEncoder().encode("user1Pass"))
        .authorities("ROLE_USER");
    }

    @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(customizer -> 
        customizer
        .requestMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated())
        .exceptionHandling(exception -> exception
        .authenticationEntryPoint(authEntryPoint))
        .sessionManagement (session -> session 
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        // http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
        
}
