package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.CategoryDto;
import com.shopping.shop.entity.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
	
}
