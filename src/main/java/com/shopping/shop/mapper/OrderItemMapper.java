package com.shopping.shop.mapper;

import org.mapstruct.Mapper;
import com.shopping.base.mapper.BaseMapper;
import com.shopping.shop.dto.OrderItemDto;
import com.shopping.shop.entity.OrderItem;

@Mapper(uses = {ProductMapper.class})
public interface OrderItemMapper extends BaseMapper<OrderItem, OrderItemDto> {
	
}
