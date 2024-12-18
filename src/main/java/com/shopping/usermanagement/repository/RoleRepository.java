package com.shopping.usermanagement.repository;

import org.springframework.stereotype.Repository;

import com.shopping.base.repository.BaseRepository;
import com.shopping.usermanagement.entity.Role;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
	
	Role findByName(String name);
}
