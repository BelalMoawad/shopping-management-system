package com.shopping.security.mapper;

import org.mapstruct.Mapper;

import com.shopping.base.mapper.BaseMapper;
import com.shopping.security.dto.AppUserDto;
import com.shopping.security.entity.AppUser;

@Mapper
public interface AppUserMapper extends BaseMapper<AppUser, AppUserDto> {
	
}
