package com.shopping.catalogmanagement.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.catalogmanagement.dto.ProductDto;
import com.shopping.catalogmanagement.entity.Product;

@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
	
}
