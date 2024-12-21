package com.shopping.shop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.entity.CartItem;
import com.shopping.shop.entity.Product;
import com.shopping.shop.repository.CartItemRepository;
import com.shopping.shop.repository.CartRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;



@Log4j2
@Service
public class CartItemService extends BaseService<CartItem, Long> {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductService productService;
	
	public CartItemService() {
		super(CartItem.class);
	}
	
	public CartItem addItemToCart(CartItem addedItem) {
		// handle detached beans
		if(addedItem.getCart() != null && addedItem.getCart().getId() != null)
			addedItem.setCart(cartRepository.findById(addedItem.getCart().getId()).get());
		
		if(addedItem.getProduct() != null && addedItem.getProduct().getId() != null)
			addedItem.setProduct(productService.findById(addedItem.getProduct().getId()));
		
		// check the item product already in cart
		// if yes, increase the quantity with carditem's quantity
		// if no, insert a new card item
		Cart cart = addedItem.getCart();
		Product product = addedItem.getProduct();
		log.info("I am here");
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
			cartItem.setQuantity(cartItem.getQuantity() + addedItem.getQuantity());
		}
		
		cartItem.setTotalPrice();
		cart.addItem(cartItem);
		CartItem retCartItem = cartItemRepository.save(cartItem);
		cartRepository.save(cart);
		return retCartItem;
	}
	
	public void removeById(Long itemId) {
		
		CartItem cartItem = findById(itemId);
		
		Cart cart = cartItem.getCart();
		
		cart.removeItem(cartItem);
		
		deleteById(itemId);
		
		cartRepository.save(cart);
		
	}
	
	public void deleteAllByCartId(Long id) {
		cartItemRepository.deleteAllByCartId(id);
	}
	
	public CartItem updateItemQuantity(Long itemId, int quantity) {
		
		CartItem cartItem = findById(itemId);
		
		Cart cart = cartItem.getCart();
		
		cartItem.setQuantity(quantity);
		
		cartItem.setTotalPrice();
		
		cart.addItem(cartItem);
		
		CartItem retCartItem = cartItemRepository.save(cartItem);
		
		cartRepository.save(cart);
		
		return retCartItem;
		
	}
	
}