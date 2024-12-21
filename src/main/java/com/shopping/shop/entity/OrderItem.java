package com.shopping.shop.entity;

import java.math.BigDecimal;

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
@Entity
@Table(name = "shop_order_items")
public class OrderItem extends BaseEntity<Long>  {
	
	private int quantity;
	
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

	public OrderItem(Order order, Product product, int quantity, BigDecimal price) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.product = product;
	}
    
    

}
