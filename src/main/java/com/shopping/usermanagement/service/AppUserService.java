package com.shopping.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.base.service.BaseService;
import com.shopping.usermanagement.entity.AppUser;
import com.shopping.usermanagement.entity.Role;
import com.shopping.usermanagement.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
public class AppUserService extends BaseService<AppUser, Long>{
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	public AppUserService() {
		super(AppUser.class);
	}
	
	public AppUser insert(AppUser user) {
		return appUserRepository.save(user);
	}
}
