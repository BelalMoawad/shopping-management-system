package com.shopping.shop.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.shopping.base.dto.BaseDto;
import com.shopping.security.dto.AppUserDto;
import com.shopping.shop.enums.OrderStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto extends BaseDto<Long> {
	
	private LocalDate orderDate;
	
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
 
    private Set<OrderItemDto> orderItems = new HashSet<>();

    private AppUserDto user;
    
}
