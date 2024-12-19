package com.shopping.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.repository.CartRepository;
import com.shopping.usermanagement.entity.AppUser;

@Service
public class CartService extends BaseService<Cart, Long> {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	public CartService() {
		super(Cart.class);
	}
	
	
	public void clearCart(Cart cart) {
		
		cartItemService.deleteAllByCartId(cart.getId());
		
		cart.clearCart();
		
		cartRepository.deleteById(cart.getId());
	}
	
	public Cart findByAppUserId(Long id) {
		return cartRepository.findByUserId(id);
	}

	public Cart initializeNewCart(AppUser user) {
        return Optional.ofNullable(findByAppUserId(user.getId()))
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    return cartRepository.save(cart);
                });
    }
}