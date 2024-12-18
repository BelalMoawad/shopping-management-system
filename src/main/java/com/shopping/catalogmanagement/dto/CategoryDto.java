package com.shopping.catalogmanagement.dto;
import com.shopping.base.dto.BaseDto;
import com.shopping.catalogmanagement.entity.Category;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto extends BaseDto<Long> {
	
	private String name;

}
