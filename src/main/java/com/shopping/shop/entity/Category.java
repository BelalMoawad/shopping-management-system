package com.shopping.shop.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
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
@Table(name = "shop_categories")
public class Category extends BaseEntity<Long> {

	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}