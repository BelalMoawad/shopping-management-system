package com.shopping.catalogmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shopping.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "cat_orders")
public class Order extends BaseEntity<Long> {
		
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date date ;
	
	@ManyToMany()
	@JoinTable(name="cat_orders_products",
			   joinColumns = @JoinColumn(name="order_id"), 
			   inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> products = new ArrayList<>();

}