package com.shopping.catalogmanagement.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.catalogmanagement.dto.CategoryDto;
import com.shopping.catalogmanagement.entity.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
	
}
