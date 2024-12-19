package com.shopping.shop.dto;
import java.math.BigDecimal;
import java.util.List;

import com.shopping.base.dto.BaseDto;
import com.shopping.shop.entity.Category;
import com.shopping.shop.entity.Image;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto extends BaseDto<Long> {
	
	private String name;
	
	private String brand;
	
	private BigDecimal price;
	
	private int inventory; // inventory = quantity
	
	private String description;
	
	private CategoryDto category;

}
