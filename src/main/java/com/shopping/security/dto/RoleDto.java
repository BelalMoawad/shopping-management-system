package com.shopping.security.dto;
import com.shopping.base.dto.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto extends BaseDto<Long> {
	
	private String name;

}
