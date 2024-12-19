package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.ProductDto;
import com.shopping.shop.entity.Product;

@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
	
}
