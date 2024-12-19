package com.shopping.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.entity.CartItem;
import com.shopping.shop.entity.Product;
import com.shopping.shop.repository.CartItemRepository;
import com.shopping.shop.repository.CartRepository;

@Service
public class CartItemService extends BaseService<CartItem, Long> {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	public CartItemService() {
		super(CartItem.class);
	}
	
	public void addItemToCart(CartItem addedItem) {
		// check the item product already in cart
		// if yes, increase the quantity with carditem's quantity
		// if no, insert a new card item
		Cart cart = addedItem.getCart();
		Product product = addedItem.getProduct();
		
		CartItem cartItem = cart.getItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst().orElse(new CartItem());
		
		if(cartItem.getId() == null) {
			cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(addedItem.getQuantity());
            cartItem.setUnitPrice(product.getPrice());
		}
		else {
			// remove existed cardItem from cart to add after if/else with updated quantity value
			cart.removeItem(cartItem);
			cartItem.setQuantity(cartItem.getQuantity() + addedItem.getQuantity());
		}
		
		cartItem.setTotalPrice();
		cart.addItem(cartItem);
		cartItemRepository.save(cartItem);
		cartRepository.save(cart);
		
	}
	
	public void removeItemFromCart(CartItem cartItem) {
		
		Cart cart = cartItem.getCart();
		
		cart.removeItem(cartItem);
		
		cartItemRepository.deleteById(cartItem.getId());
		
		cartRepository.save(cart);
		
	}
	
	public void deleteAllByCartId(Long id) {
		cartItemRepository.deleteAllByCartId(id);
	}
	
}