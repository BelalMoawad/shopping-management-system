package com.shopping.shop.entity;

import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop_images")
public class Image extends BaseEntity<Long> {
	
	@NotBlank(message = "File name must not be blank")
	private String fileName;
	
	 @NotBlank(message = "Image path must not be blank")
	private String imagePath;
	
	@NotNull(message = "Product must not be null")
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}