package com.shopping.security.service;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping.security.auth.AuthenticationRequest;
import com.shopping.security.auth.AuthenticationResponse;
import com.shopping.security.auth.RefreshTokenRequest;
import com.shopping.security.config.JwtService;
import com.shopping.security.entity.AppUser;
import com.shopping.security.repository.AppUserRepository;
import com.shopping.shop.exception.UserAlreadyExistsException;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
	
	private final AuthenticationManager auhenticationManager;
	private final AppUserRepository appUserRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	        
	public void register(AppUser request){	
		// must check if userName is taken before
		Optional<AppUser> appUser = appUserRepository.findByUserName(request.getUserName());
		if(appUser.isPresent()) 
			throw new UserAlreadyExistsException("Username \'" + request.getUserName() + "\' is already taken");
		
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
		 
		String accessToken = jwtService.generateToken(appUser, generateExtraClaims(appUser));
		String refreshToken = jwtService.generateRefreshToken(appUser);
		
		return new AuthenticationResponse(accessToken, refreshToken);
	}
	
	public ResponseEntity<?> refreshToken(RefreshTokenRequest refreshTokenRequest) {
		if (jwtService.isTokenExpired(refreshTokenRequest.getRefreshToken())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String username = jwtService.extractUsername(refreshTokenRequest.getRefreshToken());
        AppUser user = appUserRepository.findByUserName(username).orElseThrow();

        if (!jwtService.isTokenValid(refreshTokenRequest.getRefreshToken(), user)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String newAccessToken = jwtService.generateToken(user, generateExtraClaims(user));
        return ResponseEntity.ok(new AuthenticationResponse(newAccessToken, refreshTokenRequest.getRefreshToken()));
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
