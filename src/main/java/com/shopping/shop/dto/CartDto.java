package com.shopping.shop.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import com.shopping.base.dto.BaseDto;
import com.shopping.shop.entity.CartItem;
import com.shopping.usermanagement.dto.AppUserDto;
import com.shopping.usermanagement.entity.AppUser;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartDto extends BaseDto<Long> {
	
	private Long id;
	
	private BigDecimal totalAmount;

    private Set<CartItemDto> items = new HashSet<>();
    
    private AppUserDto user;
    
}
