package com.shopping.catalogmanagement.entity;

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
@Table(name = "cat_products")
public class Product extends BaseEntity<Long> {
	
	private String name;
	
	private double price;
	
	private double quantity;
	
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}