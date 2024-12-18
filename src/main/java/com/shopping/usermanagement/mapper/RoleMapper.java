package com.shopping.usermanagement.mapper;

import org.mapstruct.Mapper;

import com.shopping.base.mapper.BaseMapper;
import com.shopping.usermanagement.dto.RoleDto;
import com.shopping.usermanagement.entity.Role;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDto> {
	
}
