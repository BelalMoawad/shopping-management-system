package com.shopping.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.shopping.usermanagement.entity.AppUser;
import com.shopping.usermanagement.entity.Role;
import com.shopping.usermanagement.service.AppUserService;
import com.shopping.usermanagement.service.RoleService;

@Component
public class AppStartUp implements CommandLineRunner {
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void run(String... args) throws Exception {
		addRoleDemoData();
		addUserDemoData();
	}
	
	private void addRoleDemoData() {
		if(roleService.findAll().isEmpty()) {
			roleService.insert(new Role("Admin"));
			roleService.insert(new Role("User"));
		}
	}
	
	private void addUserDemoData() {
		if(appUserService.findAll().isEmpty()) {
			appUserService.insert(new AppUser("Ahmed", "Ali", "mail", "123",
								   Arrays.asList(roleService.findByName("Admin"))));
			appUserService.insert(new AppUser("Omar", "Reda", "user", "321",
					   Arrays.asList(roleService.findByName("User"))));
		}
	}
}
