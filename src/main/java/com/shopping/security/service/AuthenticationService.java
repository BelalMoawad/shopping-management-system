package com.shopping.security.service;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping.security.auth.AuthenticationRequest;
import com.shopping.security.auth.AuthenticationResponse;
import com.shopping.security.config.JwtService;
import com.shopping.security.entity.AppUser;
import com.shopping.security.repository.AppUserRepository;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
	
	private final AuthenticationManager auhenticationManager;
	private final AppUserRepository appUserRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	        
	public void register(AppUser request){
		// must check first 
		
		AppUser user = new AppUser();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUserName(request.getUserName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(request.getRoles());
        appUserRepository.save(user);
    }
	
	public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()
		);
		
		auhenticationManager.authenticate(authToken); 
		
		AppUser appUser = appUserRepository.findByUserName(authenticationRequest.getUsername()).get();
		 
		String jwt = jwtService.generateToken(appUser, generateExtraClaims(appUser));
		
		return new AuthenticationResponse(jwt);
	}


	private Map<String, Object> generateExtraClaims(AppUser appUser) {
		
		Map<String, Object> extraClaims = new HashMap<>();
		
		extraClaims.put("firstName", appUser.getFirstName());
		extraClaims.put("lastName", appUser.getLastName());
		appUser.getRoles().forEach(role -> {
			extraClaims.put("role_" + role.getId(), role.getName());
		});
		
		return extraClaims;
	}
}
