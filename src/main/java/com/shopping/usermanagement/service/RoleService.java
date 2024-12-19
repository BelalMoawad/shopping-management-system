package com.shopping.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Category;
import com.shopping.usermanagement.entity.AppUser;
import com.shopping.usermanagement.entity.Role;
import com.shopping.usermanagement.repository.RoleRepository;

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
