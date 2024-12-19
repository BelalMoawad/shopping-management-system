package com.shopping.shop.dto;
import java.sql.Blob;

import com.shopping.base.dto.BaseDto;
import com.shopping.shop.entity.Category;
import com.shopping.shop.entity.Product;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageDto extends BaseDto<Long> {
	
	private String fileName;
	
	private String imagePath;
	
	private ProductDto product;

}
