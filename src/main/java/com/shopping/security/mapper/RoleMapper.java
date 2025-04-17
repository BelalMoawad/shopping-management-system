package com.shopping.security.mapper;

import org.mapstruct.Mapper;

import com.shopping.base.mapper.BaseMapper;
import com.shopping.security.dto.RoleDto;
import com.shopping.security.entity.Role;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDto> {
	
}
