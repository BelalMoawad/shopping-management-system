package com.shopping.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.base.service.BaseService;
import com.shopping.security.entity.AppUser;
import com.shopping.security.entity.Role;
import com.shopping.security.repository.RoleRepository;
import com.shopping.shop.entity.Category;

@Service
public class RoleService extends BaseService<Role, Long>{
	
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleService() {
		super(Role.class);
	}
	
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
	
	public Role insert(Role role) {
		return roleRepository.save(role);
	}
}
