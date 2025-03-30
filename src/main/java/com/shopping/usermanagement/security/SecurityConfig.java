package com.shopping.usermanagement.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Define PasswordEncoder first
    }
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
            .username("ahmed")
            .password(passwordEncoder().encode("12345"))
            .roles("USER")
            .build();
        UserDetails admin = User.builder()
                .username("belal")
                .password(passwordEncoder().encode("54321"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
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
            .httpBasic(withDefaults());
        return http.build();
    }
}
