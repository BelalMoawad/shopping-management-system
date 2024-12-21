package com.shopping.shop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.repository.CartRepository;
import com.shopping.usermanagement.entity.AppUser;
import com.shopping.usermanagement.service.AppUserService;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CartService extends BaseService<Cart, Long> {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private AppUserService appUserService;
	
	public CartService() {
		super(Cart.class);
	}
	
	@Transactional
	public void clearCart(Long cartId) {
		
		findById(cartId); // if cartId doesn't exist it throw exception
		
		cartItemService.deleteAllByCartId(cartId);
	}
	
	public Cart findByAppUserId(Long id) {
		log.info("user id = " + id);
		Cart cart = cartRepository.findByUserId(id);
		log.info("cart id = " + cart.getId());
		return cart;
	}

	public Cart initializeNewCart(AppUser user) {
		// if i passed a new user
		if (user.getId() == null) 
			appUserService.insert(user);
				
	    // Handle Detached user
	    AppUser persistedUser = appUserService.findById(user.getId());
	    
	    // Try to find the cart for the user
	    Cart existingCart = cartRepository.findByUserId(persistedUser.getId());
	    if (existingCart != null) {
	        log.info("Cart already exists for user ID: " + persistedUser.getId());
	        return existingCart;
	    }

	    // Create a new cart if none exists
	    log.info("Creating a new cart for user ID: " + persistedUser.getId());
	    Cart newCart = new Cart();
	    newCart.setUser(persistedUser);
	    newCart = cartRepository.save(newCart);
	    log.info("New cart created with ID: " + newCart.getId());
	    return newCart;
    }
}