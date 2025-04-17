package com.shopping.security.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.shopping.security.entity.AppUser;
import com.shopping.security.entity.SecurityUser;
import com.shopping.security.repository.AppUserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private final AppUserRepository appUserRepository;
	private final JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// 1) obtain header that contain JWT token
		// authHeader(Bearer JWT) example: [ Authorization: Bearer <your-JWT-token> ] 
		String authHeader = request.getHeader("Authorization"); //Bearer JWT
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response); // in case end-point doesn't need authentication need to pass this filter
			return;
		}
		
		// 2) obtain JWT token
		String jwt = authHeader.split(" ")[1];
		
		// 3) obtain subject/userName in JWT
		String username = jwtService.extractUsername(jwt);
		
		// 4) set authenticated object inside our security context
		AppUser appUser = appUserRepository.findByUserName(username).get();
		SecurityUser securityUser = new SecurityUser(appUser);
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				username, null, securityUser.getAuthorities()
		);
		
		SecurityContextHolder.getContext().setAuthentication(authToken);
		
		// 5) execute rest of the filters
		filterChain.doFilter(request, response);
				
	}

}
