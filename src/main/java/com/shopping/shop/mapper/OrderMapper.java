package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.OrderDto;
import com.shopping.shop.entity.Order;
import com.shopping.usermanagement.mapper.AppUserMapper;

@Mapper(uses = {AppUserMapper.class, OrderItemMapper.class})
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
	
}
