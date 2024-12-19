package com.shopping.shop.entity;

import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	
	private String fileName;
	
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}