package com.shopping.usermanagement.mapper;

import org.mapstruct.Mapper;

import com.shopping.base.mapper.BaseMapper;
import com.shopping.usermanagement.dto.AppUserDto;
import com.shopping.usermanagement.entity.AppUser;

@Mapper
public interface AppUserMapper extends BaseMapper<AppUser, AppUserDto> {
	
}
