package com.shopping.shop.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shop.dto.CartItemDto;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.entity.CartItem;
import com.shopping.shop.mapper.CartItemMapper;
import com.shopping.shop.service.CartItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/cart_item")
@RequiredArgsConstructor
public class CartItemController {
	
	private final CartItemService cartItemService;

	private final CartItemMapper cartItemMapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		CartItemDto cartItemDto = cartItemMapper.map(cartItemService.findById(id));
		return ResponseEntity.ok(cartItemDto);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addItemToCart(@RequestBody CartItem cartItem) {
		CartItemDto cartItemDto = cartItemMapper.map(cartItemService.addItemToCart(cartItem));
		return ResponseEntity.ok(cartItemDto);
	}
	
	@DeleteMapping("/{id}")
	public void removeItemFromCart(@PathVariable Long id) {
		cartItemService.removeById(id);	
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateItemQuantity(@RequestParam Long itemId, @RequestParam int quantity) {
		CartItemDto cartItemDto = cartItemMapper.map(cartItemService.updateItemQuantity(itemId, quantity));
		return ResponseEntity.ok(cartItemDto);
	}

}
