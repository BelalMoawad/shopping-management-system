package com.shopping.usermanagement.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.usermanagement.entity.AppUser;
import com.shopping.usermanagement.entity.SecurityUser;
import com.shopping.usermanagement.repository.AppUserRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AppUserService extends BaseService<AppUser, Long> implements UserDetailsService{
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	public AppUserService() {
		super(AppUser.class);
	}
	
	public AppUser insert(AppUser user) {
		return appUserRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("I'm here to authenticate user_name :- " + username);
		Optional<AppUser> appUser = appUserRepository.findByUserName(username);
		
		if(!appUser.isPresent()) {
			throw new UsernameNotFoundException("This user is not found with userName:- " + username);
		}
		log.info("appUser last name :- " + appUser.get().getLastName());
		return new SecurityUser(appUser.get());
	}
	
	
}
