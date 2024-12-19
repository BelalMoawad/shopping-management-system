package com.shopping.shop.dto;

import java.math.BigDecimal;
import com.shopping.base.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemDto extends BaseDto<Long> {
	
	private Long id;
	
	private int quantity;
	
    private BigDecimal unitPrice;

    private ProductDto product;
    
}
