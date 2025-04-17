package com.shopping.security.repository;

import org.springframework.stereotype.Repository;

import com.shopping.base.repository.BaseRepository;
import com.shopping.security.entity.Role;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
	
	Role findByName(String name);
}
