package com.shopping.usermanagement.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails  {

	private AppUser user;
	
	public SecurityUser(AppUser user) {
		this.user = user;
	}
	
	@Override
	public String getUsername() {
		return user.getUserName();
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(!user.getRoles().isEmpty()) {
		     user.getRoles().forEach(role -> {
		        authorities.add(new SimpleGrantedAuthority(role.getName()));	
		     });
		 }
		 return authorities;
	}

}
