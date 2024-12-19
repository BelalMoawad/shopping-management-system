package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.CartDto;
import com.shopping.shop.entity.Cart;

@Mapper(uses = {CartItemMapper.class})
public interface CartMapper extends BaseMapper<Cart, CartDto> {
	
}