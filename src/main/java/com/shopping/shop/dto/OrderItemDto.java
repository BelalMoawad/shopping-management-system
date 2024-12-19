package com.shopping.shop.dto;

import java.math.BigDecimal;
import com.shopping.base.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDto extends BaseDto<Long> {
	
	private int quantity;
	
    private BigDecimal price;

    private ProductDto product;
    
}