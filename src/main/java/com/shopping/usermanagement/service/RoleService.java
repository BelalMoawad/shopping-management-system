package com.shopping.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.base.service.BaseService;
import com.shopping.usermanagement.entity.Role;
import com.shopping.usermanagement.repository.RoleRepository;

@Service
public class RoleService extends BaseService<Role, Long>{
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}
