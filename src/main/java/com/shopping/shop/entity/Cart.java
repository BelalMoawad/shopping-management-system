package com.shopping.shop.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopping.base.entity.BaseEntity;
import com.shopping.security.entity.AppUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop_carts")
public class Cart extends BaseEntity<Long> {
	
	@Max(value = 1000000, message = "Maximum card totalPrice is 1 milion EGP")
	private BigDecimal totalAmount = BigDecimal.ZERO;
	
	
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> items = new HashSet<>();
    

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    public void addItem(CartItem item) {
    	log.info("before " + this.items.size());
        this.items.add(item);
        log.info("after " + this.items.size());
        item.setCart(this);
        updateTotalAmount();
    }

    public void removeItem(CartItem item) {
        this.items.remove(item);
        
        item.setCart(null);
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        this.totalAmount = items.stream().map(item -> {
            BigDecimal unitPrice = item.getUnitPrice();
            if (unitPrice == null) 
                return  BigDecimal.ZERO;
           
            return unitPrice.multiply(BigDecimal.valueOf(item.getQuantity()));
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public void clearCart(){
        this.items.clear();
        updateTotalAmount();
    }

}