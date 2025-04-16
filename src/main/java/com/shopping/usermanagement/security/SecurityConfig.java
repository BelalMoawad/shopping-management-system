package com.shopping.usermanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	private final AuthenticationProvider authenticationProvider;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll()
            		.requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
            		.requestMatchers("/error").permitAll()
            		.requestMatchers("/api/v1/user/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/role/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/category/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/product/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/image/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/cart/**").hasRole("USER")
                	.requestMatchers("/api/v1/cart_item/**").hasRole("USER")
                	.requestMatchers("/api/v1/order/**").hasRole("USER")	
                .anyRequest().denyAll()
            );

        return http.build();
    }
	
	
}