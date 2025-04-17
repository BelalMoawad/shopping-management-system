package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.security.mapper.AppUserMapper;
import com.shopping.shop.dto.OrderDto;
import com.shopping.shop.entity.Order;

@Mapper(uses = {AppUserMapper.class, OrderItemMapper.class})
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
	
}
