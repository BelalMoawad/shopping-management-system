package com.shopping.usermanagement.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.shopping.usermanagement.service.AppUserService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private AppUserService myUserDetailsService;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/api/v1/user/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/role/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/category/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/product/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/image/**").hasRole("ADMIN")
                	.requestMatchers("/api/v1/cart/**").hasRole("USER")
                	.requestMatchers("/api/v1/cart_item/**").hasRole("USER")
                	.requestMatchers("/api/v1/order/**").hasRole("USER")	
                .anyRequest().authenticated()
            )
            .userDetailsService(myUserDetailsService)
            .httpBasic(withDefaults());

        return http.build();
    }
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}