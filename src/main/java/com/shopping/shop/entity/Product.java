package com.shopping.shop.entity;

import java.math.BigDecimal;
import java.util.List;

import com.shopping.base.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "shop_products")
public class Product extends BaseEntity<Long> {
	
	private String name;
	
	private String brand;
	
	private BigDecimal price;
	
	private int inventory; // inventory = quantity
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;

	public Product(String name, String brand, BigDecimal price, int inventory, String description, Category category) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.inventory = inventory;
		this.description = description;
		this.category = category;
	}
	
	

}