package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.CartItemDto;
import com.shopping.shop.entity.CartItem;

@Mapper(uses = {ProductMapper.class})
public interface CartItemMapper extends BaseMapper<CartItem, CartItemDto> {
	
}