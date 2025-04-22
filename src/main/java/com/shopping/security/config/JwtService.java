package com.shopping.security.config;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.security.entity.AppUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${security.jwt.expiration-minutes}")
	private long EXPIRATION_MINUTES;
	
	@Value("${security.jwt.refresh-expiration-days}")
	private long REFRESH_EXPIRATION_DAYS;
	
	@Value("${security.jwt.secret-key}")
	private String SECRET_KEY;
	
	public String generateToken(AppUser appUser, Map<String, Object> extraClaims) {
		
		Date issueAt = new Date(System.currentTimeMillis());
		Date expirationDate = new Date(issueAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));
		
		return Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(appUser.getUserName())
				.setIssuedAt(issueAt)
				.setExpiration(expirationDate)
				.signWith(generateKey(), SignatureAlgorithm.HS256)
				.compact();		
	}
	
	public String generateRefreshToken(AppUser appUser) {
	    Date issueAt = new Date(System.currentTimeMillis());
	    Date expirationDate = new Date(issueAt.getTime() + (REFRESH_EXPIRATION_DAYS * 24 * 60 * 60 * 1000));
	    
	    return Jwts.builder()
	            .setSubject(appUser.getUserName())
	            .setIssuedAt(issueAt)
	            .setExpiration(expirationDate)
	            .signWith(generateKey(), SignatureAlgorithm.HS256)
	            .compact();
	}
	
	public boolean isTokenValid(String token, AppUser appUser) {
	    final String username = extractUsername(token);
	    return (username.equals(appUser.getUserName())) && !isTokenExpired(token);
	}

	public boolean isTokenExpired(String token) {
	    return extractExpiration(token).before(new Date());
	}

	public Date extractExpiration(String token) {
	    return extractAllClaims(token).getExpiration();
	}

	private Key generateKey() {
		byte[] secretkeyAsBytes = Decoders.BASE64.decode(SECRET_KEY);	
		return Keys.hmacShaKeyFor(secretkeyAsBytes);
	}

	public String extractUsername(String jwt) {
		return extractAllClaims(jwt).getSubject();
	}

	private Claims extractAllClaims(String jwt) {
		return Jwts.parserBuilder().setSigningKey(generateKey()).build()
				.parseClaimsJws(jwt).getBody();		
	}
}
