 package com.shopping.shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.shop.dto.CartDto;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.mapper.CartMapper;
import com.shopping.shop.service.CartService;
import com.shopping.usermanagement.entity.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@RequestMapping("${api.prefix}/cart")
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;

	private final CartMapper cartMapper;

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody AppUser user) {
		CartDto cartDto = cartMapper.map(cartService.initializeNewCart(user));
		return ResponseEntity.ok(cartDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		CartDto CartDto = cartMapper.map(cartService.findById(id));
		return ResponseEntity.ok(CartDto);
	}
	
	@DeleteMapping("/{cartId}")
	public void clearCart(@PathVariable Long cartId) {
		cartService.clearCart(cartId);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> findByAppUserId(@PathVariable Long userId) {
		CartDto CartDto = cartMapper.map(cartService.findByAppUserId(userId));
		return ResponseEntity.ok(CartDto);
	}
	
	
}
